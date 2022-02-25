package com.rangga.reactive.controllers;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.reactive.models.EmployeeEvent;
import com.rangga.reactive.models.EmployeeModel;
import com.rangga.reactive.repositories.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {
	
	private EmployeeRepository er;
	
	public EmployeeController(EmployeeRepository employee) {
		this.er = employee;
	}

	@GetMapping("/all")
	public Flux<EmployeeModel> getAll(){
		return er.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<EmployeeModel> getId(@PathVariable("id") final String empId){
		return er.findById(empId);
	}
	
	@GetMapping(value = "{id}/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String empId){
		
		return er.findById(empId)
		.flatMapMany(employee->{
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
			
			Flux<EmployeeEvent> employeeFlux =
					Flux.fromStream(
							Stream.generate(()-> new EmployeeEvent(employee,new Date())));
			
			
			return Flux.zip(interval, employeeFlux)
					.map(Tuple2::getT2);
		});
		
		
	}

}

package com.rangga.reactive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.rangga.reactive.models.EmployeeModel;
import com.rangga.reactive.repositories.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository er;
	
	public Mono<ServerResponse> getAll(ServerRequest request){
		Flux<EmployeeModel> employee = er.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(employee,EmployeeModel.class);
	}

}

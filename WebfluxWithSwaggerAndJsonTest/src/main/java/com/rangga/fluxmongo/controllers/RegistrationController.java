package com.rangga.fluxmongo.controllers;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rangga.fluxmongo.models.StudentModels;
import com.rangga.fluxmongo.service.RegistrationService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("adminDept")
@AllArgsConstructor
@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping
	public Flux<StudentModels> getAll() throws JsonMappingException, JsonProcessingException {
		System.out.println("::will returns ALL Students records::");
		//json tester
		
		return registrationService.getAll();
	}
	
	//save with java json
	@GetMapping("/json")
	public Mono test() {
		String json = "{ \"firstName\" : \"Black\", \"lastName\" : \"BMW\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		StudentModels student = null;
		try {
			student = objectMapper.readValue(json, StudentModels.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationService.save(student);
	}
	
	@GetMapping("{id}")
	public Mono<StudentModels> getById(@PathVariable("id") final String id) {
		System.out.println("::will return a Student record::");
		return registrationService.getById(id);
	}

	@PutMapping("{id}")
	public Mono updateById(@PathVariable("id") final String id, @RequestBody final StudentModels student) {
		System.out.println("::update the Student record::");
		return registrationService.update(id, student);
	}

	@PostMapping
	public Mono save(@RequestBody final StudentModels student) {
		System.out.println("will insert the student's record :: "+ student.getId() + " :: " + student.getFirstName());
		return registrationService.save(student);
	}

	@DeleteMapping("{id}")
	public Mono delete(@PathVariable final String id) {
		System.out.println("::will delete a Student record::");
		return registrationService.delete(id);
	}

}

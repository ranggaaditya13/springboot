package com.rangga.fluxmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Flux<StudentModels> getAll() {
		System.out.println("::will returns ALL Students records::");
		return registrationService.getAll();
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

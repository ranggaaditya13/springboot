package com.rangga.reactive.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.rangga.reactive.services.EmployeeService;

@Configuration
public class EmployeeRouter {
	
	@Bean
	public RouterFunction<ServerResponse> router(EmployeeService service){
		RouterFunction<ServerResponse> employee = RouterFunctions.
				route(RequestPredicates.GET("/getall").and(RequestPredicates
						.accept(MediaType.APPLICATION_JSON)),service::getAll);
		
		return employee;
	}

}

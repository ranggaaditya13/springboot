package com.rangga.reactive;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rangga.reactive.models.EmployeeModel;
import com.rangga.reactive.repositories.EmployeeRepository;

@SpringBootApplication
public class ReactiveRouterTestApplication {
	
	@Bean
	CommandLineRunner empolyees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.deleteAll().subscribe(null,null,()->{
				Stream.of(new EmployeeModel(UUID.randomUUID().toString(),"Rangga",23000L),
						new EmployeeModel(UUID.randomUUID().toString(),"Rangga1",23000L),
						new EmployeeModel(UUID.randomUUID().toString(),"Rangga2",23000L),
						new EmployeeModel(UUID.randomUUID().toString(),"Rangga3",23000L)
						).forEach(employee ->{
							employeeRepository.save(employee)
							.subscribe(System.out::println);
						});
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRouterTestApplication.class, args);
	}

}

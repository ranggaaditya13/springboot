package com.rangga.fluxmongo.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rangga.fluxmongo.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Rangga Aditya API Test",
				"Ini Demo API Menggunakan Springboot Webflux",
				"v1.0",
				"Terms Of Service Deskripsi",
				new Contact("Rangga Aditya", "www.stackdolphin.com","@ranggaaditya13"),
				"Apache Lisence, Isi License",
				"www.titleapahe",
				Collections.emptyList());
		return apiInfo;
	}
	
	

}

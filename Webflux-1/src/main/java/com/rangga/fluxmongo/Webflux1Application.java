package com.rangga.fluxmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class Webflux1Application {

	public static void main(String[] args) {
		SpringApplication.run(Webflux1Application.class, args);
		
		Flux<String> cobaFlux = Flux.just("Coba","dipanggil","satu-satu")
				.concatWith(Flux.just("best","Ter The Best aja lah")).log();
		
		cobaFlux.subscribe(System.out::println,
				e -> System.err.println("keluar Jika ada Error : "+ e),
				()->System.out.println("Selesai Menjalankan Flux"));
	}

}

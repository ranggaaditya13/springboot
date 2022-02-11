package com.rangga.webflux.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.rangga.webflux.dto.ProductDto;
import com.rangga.webflux.entity.Product;

import reactor.core.publisher.Flux;

@EnableReactiveMongoRepositories
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

	Flux<ProductDto> findByPriceBeetween(Range<Double> priceRange);
	

}

package com.rangga.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.webflux.dto.ProductDto;
import com.rangga.webflux.repository.ProductRepository;
import com.rangga.webflux.util.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ProductService {

	
	@Autowired
	private ProductRepository repository;
	
	public Flux<ProductDto> getProducts(){
		return repository.findAll().map(AppUtils::entityToDto);
	}
	
	public Mono<ProductDto> getProduct(String id){
		return repository.findById(id).map(AppUtils::entityToDto);
	}
	
	public Flux<ProductDto> getProductInRange(Double min,Double max){
		return repository.findByPriceBeetween(Range.closed(min, max));
	}
	
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
		return productDtoMono.map(AppUtils::DtoToEntity)
				.flatMap(repository::insert)
				.map(AppUtils::entityToDto);
	}
	
	public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){
		return repository.findById(id)
				.flatMap(p->productDtoMono.map(AppUtils::DtoToEntity))
				.doOnNext(e->e.setId(id))
				.flatMap(repository::save)
				.map(AppUtils::entityToDto);
	}
	
	public Mono<Void> deleteProduct(String id){
		return repository.deleteById(id);
	}
}

package com.rangga.webflux.util;

import org.springframework.beans.BeanUtils;

import com.rangga.webflux.dto.ProductDto;
import com.rangga.webflux.entity.Product;

public class AppUtils {
	
	public static ProductDto entityToDto(Product product) {
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);
		return dto;
	}
	
	public static Product DtoToEntity(ProductDto dto) {
		Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		return product;
	}

}

package com.suresh.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suresh.product.DTO.ProductRequest;
import com.suresh.product.DTO.ProductResponse;
import com.suresh.product.model.Product;
import com.suresh.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		productRepository.save(product);

	}

	public List<ProductResponse> getAllProducts() {
		List<Product> prodcuts = productRepository.findAll();
		List<ProductResponse> productResponses = prodcuts
				.stream().map(product -> ProductResponse.builder().name(product.getName())
						.description(product.getDescription()).price(product.getPrice()).build())
				.collect(Collectors.toList());
		return productResponses;
	}

}

package com.suresh.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.suresh.product.DTO.ProductRequest;
import com.suresh.product.DTO.ProductResponse;
import com.suresh.product.model.Product;
import com.suresh.product.service.ProductService;

@RestController
@RequestMapping("product/v1")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/createProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	
	@GetMapping("/getAllProducts")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProduct/{id}")
	public ProductResponse getProductById(@PathVariable(value="id") String id) throws Exception {
		return productService.findProductById(id);
	}

}

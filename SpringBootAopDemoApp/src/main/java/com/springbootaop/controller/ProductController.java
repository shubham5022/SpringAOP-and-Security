package com.springbootaop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootaop.model.Product;
import com.springbootaop.services.ProductSeriveImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductSeriveImpl productSeriveImpl;

	@GetMapping("/getProducts")
	public List<Product> getProduct() {
		return productSeriveImpl.getAllProducts();
	}

	@PostMapping("/saveProducts")
	public Product saveProduct(@RequestBody Product p) {
		return productSeriveImpl.addProduct(p);
	}

}

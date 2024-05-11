package com.springbootaop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootaop.model.Product;
import com.springbootaop.repository.ProductRepository;

@Service
public class ProductSeriveImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public List<Product> getAllProducts() {
		return	productRepository.findAll();
		
	}

	@Override
	public Product addProduct(Product p) {
		
		return	productRepository.save(p);
	}
	
	

}

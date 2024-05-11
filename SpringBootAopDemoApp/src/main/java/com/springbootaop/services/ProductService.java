package com.springbootaop.services;

import java.util.List;

import com.springbootaop.model.Product;


public interface ProductService {
	
	 List<Product> getAllProducts();
	 
	 Product addProduct (Product p);

}

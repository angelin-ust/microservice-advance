package com.ust.server.service;

import java.util.List;

import com.ust.server.resource.Product;

public interface ProductService {

	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);
}

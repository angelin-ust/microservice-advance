package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resource.User;


@Service
public class ProductService {

	
	//services is calling the repository 
	//service acts as a link
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	public Product getProduct(long productId) {
	//	return repository.getProduct(productId);
		Optional <Product> optional=productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		else
		{
			return null;
		}
	}
//	
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	
//	working code
//	@Transactional(propagation=Propagation.REQUIRED)
////	public boolean add(Product product)
//	public Product add(Product product){
//		Product productT= productRepository.save(product);
//		User user=new User();
//		user.setUserId(11L);
//		user.setDateTime(System.currentTimeMillis()+"8979797979999999");
//		RuntimeException exception=null;
//		User userT=userRepository.save(user);
//		return productT; 
//	}
	
	
	
	@Transactional(propagation=Propagation.REQUIRED)
//	public boolean add(Product product)
	public Product add(Product product){
		Product productT= productRepository.save(product);
		User user=new User();
		user.setUserId(11L);
		user.setDateTime(System.currentTimeMillis()+"8979797979999999");
		RuntimeException exception=null;
		User userT=userRepository.save(user);
		return productT; 
	}
	
	
//	
	//update
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
//	
	//delete
	public void deleteProduct(long productId) {
		 productRepository.deleteById(productId);
	}
}





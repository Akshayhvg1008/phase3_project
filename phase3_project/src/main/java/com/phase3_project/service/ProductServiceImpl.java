package com.phase3_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3_project.model.Product;
import com.phase3_project.model.Admin;

import com.phase3_project.model.purchased_db;
import com.phase3_project.repository.ProductRepository;
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	@Override
	@Transactional
	public void saveProduct(Product theProduct) {

		productRepository.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		return productRepository.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		productRepository.deleteProduct(theId);
	}

	@Override
	@Transactional
	public List<Product> doCategorize(String category) {
		return productRepository.doCategorize(category);
	}

	@Override
	@Transactional
	public void changePassword(String username, String password, String newpassword) {
		 productRepository.changePassword(username, password, newpassword);
	}

	
}

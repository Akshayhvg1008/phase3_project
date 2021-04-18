package com.phase3_project.repository;

import java.util.List;

import com.phase3_project.model.Product;
import com.phase3_project.model.purchased_db;

public interface ProductRepository {

    public List<Product> getProducts();
	
	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);
	
	public List<Product> doCategorize(String category);

	public void deleteProduct(int theId);
	
	 public void changePassword(String username,String password,String newpassword);

}

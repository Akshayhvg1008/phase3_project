package com.phase3_project.repository;

import java.util.List;

import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;

public interface UserRepository {

    public List<Product> getProducts();
	//public void savepersonal(String name,String age,String city,String gender,int id);
	public List<User> getAllUserData();
	public List<User> getUserData(String user);
	public int valid(String username,String password);

	
}

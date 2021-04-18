package com.phase3_project.service;

import java.util.List;

import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;

public interface UserService {

    public List<Product> getProducts();
	public List<User> getAllUserData();
	public List<User> getUserData(String user);
	public int valid(String username,String password);

}

package com.phase3_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;
import com.phase3_project.repository.UserRepository;
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public List<User> getAllUserData() {
		return userRepository.getAllUserData();
	}

	@Override
	@Transactional
	public List<User> getUserData(String user) {
		return userRepository.getUserData(user);
	}
	@Override
	@Transactional
	public int valid(String username, String password) {
		return userRepository.valid(username, password);
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return userRepository.getProducts();
	}

	

}

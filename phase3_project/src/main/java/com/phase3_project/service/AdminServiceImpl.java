package com.phase3_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3_project.repository.AdminRepository;
@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	@Transactional
	public int valid(String username, String password) {
		return adminRepository.valid(username, password);
	}

}

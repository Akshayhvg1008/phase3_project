package com.phase3_project.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phase3_project.model.Product;
import com.phase3_project.model.purchased_db;
import com.phase3_project.service.AdminService;
import com.phase3_project.service.ProductService;
import com.phase3_project.service.PurchasedService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@PostMapping("/loginValidate")
	public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password) {
		int k = adminService.valid(username, password);
		if (k == 1)
			return "redirect:/products/list";
		else
			return "Invalid-username-pass";
	}
}

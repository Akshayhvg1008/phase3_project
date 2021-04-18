package com.phase3_project.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.phase3_project.model.Admin;
import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;
import com.phase3_project.service.ProductService;
import com.phase3_project.service.PurchasedService;
import com.phase3_project.service.UserService;

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

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PurchasedService purchasedService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		List<Product> theProducts = productService.getProducts();
		
		theModel.addAttribute("products",theProducts);
		
		return "list-products"; 
	}
	@GetMapping("/getAllUsers")
	public String getAllUsers(Model theModel) {
		List<User> theUsers = userService.getAllUserData();
		
		theModel.addAttribute("User",theUsers);
		
		return "list-users"; 
	}
	
	@GetMapping("/getByName")
	public String getByName(@RequestParam("name") String user,Model theModel) {
		List<User> theUser =userService.getUserData(user);
		
		theModel.addAttribute("User",theUser);
		
		return "list-user-by-name"; 
	}
	@GetMapping("/getByDate")
	public String getByDate(@RequestParam("date") String theDate,Model theModel) {
		List<purchased_db> thePurchased = purchasedService.getByDate(theDate);
		
		theModel.addAttribute("purchased_db",thePurchased);
		
		return "list-by-date-category"; 
	}
	
	@GetMapping("/getByCategory")
	public String getByCategory(@RequestParam("category") String theCategory,Model theModel) {
		List<purchased_db> thePurchased = purchasedService.getByCategory(theCategory);
		
		theModel.addAttribute("purchased_db",thePurchased);
		return "list-by-date-category"; 
	}
	@GetMapping("/doCategorize")
	public String doCategorize(@RequestParam("category") String theCategory,Model theModel) {
		
		List<Product> theCategorized = productService.doCategorize(theCategory);
		theModel.addAttribute("products",theCategorized);
		return "categorize"; 
	}
	
	@GetMapping("/change-password")
	public String changepassword(){
		return "change-password";
	}
	
	
	
	@PostMapping("/saveNewPassword")
	public String saveNewPassword(
			@RequestParam("username") String un,@RequestParam("password") String pwd,
			@RequestParam("newpassword") String newpd) {
		
		// save the customer using our service
		productService.changePassword(un, pwd, newpd);
		return "redirect:/products/list";
	}
	@Autowired
    private SessionFactory sessionFactory;


	@GetMapping("/showFormForSearch")
	public String showFormForSearch(Model theModel) {
		return "search_user";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		// save the customer using our service
		productService.saveProduct(theProduct);	
		
		return "redirect:/products/list";
	}
	@PostMapping("/searchUser")
	public String saveUser(HttpServletRequest req)  {
		
		String k=req.getParameter("name");
		String var="";
		HttpSession see=req.getSession();
		see.setAttribute("name", k);
		
		return "show-purchased_db";
	}

	/*
	 * @PostMapping("/categorize") public String categorize(HttpServletRequest req)
	 * {
	 * 
	 * String k=req.getParameter("cat"); String var=""; HttpSession
	 * see=req.getSession(); see.setAttribute("cat", k);
	 * 
	 * return "categorize"; }
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
									Model theModel) {
		
		Product theProduct = productService.getProduct(theId);	
		
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the customer
		productService.deleteProduct(theId);
		
		return "redirect:/products/list";
	}
}

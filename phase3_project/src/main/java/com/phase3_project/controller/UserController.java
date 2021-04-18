package com.phase3_project.controller;

import java.net.http.HttpRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
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

import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;
import com.phase3_project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	int n = 0;
	private static final ArrayList<Integer> rand = new ArrayList<Integer>();

	@GetMapping("/list_for_user")
	public String listProducts(Model theModel) {
		
		Random r = new Random();
		n = 10000 + r.nextInt(90000);
		while (rand.contains(n)) {
			n = 10000 + r.nextInt(90000);
		}
		
		List<Product> theProducts = userService.getProducts();
		theModel.addAttribute("products", theProducts);
		return "list_for_user";
	}
	@GetMapping("/done")
	public String done() {
		return "done";
	}
	

	@GetMapping("/getid")
	public String getid(@RequestParam("productId") String productId,HttpServletRequest req) {

		HttpSession h=req.getSession();
		h.setAttribute("id", n);
		h.setAttribute("product_id", productId);		return "fill-form";
	}

	public static String getDate() {
		int startYear=2020;									
		int endYear=2021;									
		long start = Timestamp.valueOf(startYear+1+"-1-1 0:0:0").getTime();
		long end = Timestamp.valueOf(endYear+"-1-1 0:0:0").getTime();
		long ms=(long) ((end-start)*Math.random()+start);	
		Date pd=new Date(ms);
		return pd.toString();
	}
	@Autowired
	private SessionFactory sessionFactory;
	@PostMapping("/addToDb")
	@org.springframework.transaction.annotation.Transactional
	public String addToDb(HttpServletRequest req,
			@RequestParam("name") String name,
			@RequestParam("age") String age,
			@RequestParam("city") String city,
			@RequestParam("gender") String gender)
	{
		String m="";
		purchased_db  p=new purchased_db();
		p.setPurchased_id(n);
		p.setName(name);
		p.setAge(age);
		p.setCity(city);
		p.setGender(gender);
		
		HttpSession see=req.getSession(false);
		if(see!=null)
		{  
		m=(String)see.getAttribute("product_id");
		}
		sessionFactory.openSession();
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query<Product> theQuery = currentSession.createQuery("from Product where id='"+m+"'", Product.class);
		List<Product> user1 = theQuery.getResultList();
		for(Product object:user1)
		{
			p.setProduct_id(Integer.toString(object.getId()));
			p.setProduct_name(object.getName());
			p.setPrice(object.getPrice());
			 p.setCompany(object.getCompany());
			p.setCategory(object.getCategory());
		}
		p.setDate(getDate());
		currentSession.save(p);
     
				return "added-to-cart";
	}
	@PostMapping("/loginValidate")
	public String loginValidate(@RequestParam("username") String username, @RequestParam("password") String password) {
		int k = userService.valid(username, password);
		if (k == 1)
			return "redirect:/user/list_for_user";
		else
			return "Invalid-username-pass";
	}

}

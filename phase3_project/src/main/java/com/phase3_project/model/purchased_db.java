package com.phase3_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchased_db")
public class purchased_db {

	@Id
	@Column(name = "purchased_id")
	private int purchased_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "product_id")
	private String product_id;
	
	public int getPurchased_id() {
		return purchased_id;
	}
	public void setPurchased_id(int purchased_id) {
		this.purchased_id = purchased_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	@Column(name = "price")
	private String price;
	
	@Column(name = "company")
	private String company;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "category")
	private String category;
	public int getId() {
		return purchased_id;
	}
	public void setId(int id) {
		this.purchased_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}

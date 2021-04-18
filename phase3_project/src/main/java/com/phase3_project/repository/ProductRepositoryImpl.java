package com.phase3_project.repository;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.phase3_project.model.Product;
import com.phase3_project.model.purchased_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository(value = "productRepository")
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product order by price",Product.class);
		List<Product> products = theQuery.getResultList();
		return products;
	}
	
	@Override
	public void saveProduct(Product theProduct) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProduct(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Product theCustomer = currentSession.get(Product.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteProduct(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}



	@Override
	public List<Product> doCategorize(String category) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product where category='"+category+"'",Product.class);
		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	public void changePassword(String username, String password,String newpassword) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("update Admin set password=:newpassword where username=:username");
		theQuery.setParameter("newpassword", newpassword);
		theQuery.setParameter("username", username);
		
		theQuery.executeUpdate();
	}


}
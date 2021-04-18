package com.phase3_project.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phase3_project.model.Admin;
import com.phase3_project.model.Product;
import com.phase3_project.model.User;
import com.phase3_project.model.purchased_db;

@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUserData() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> user = theQuery.getResultList();
		return user;
	}

	@Override
	public List<User> getUserData(String user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where name='" + user + "'", User.class);
		List<User> user1 = theQuery.getResultList();
		return user1;
	}

	@Override
	public int valid(String username, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where username=:username and password=:password");
		theQuery.setParameter("username", username);
		theQuery.setParameter("password", password);
		User hari = (User) theQuery.uniqueResult();
		if (hari != null)
			return 1;
		else
			return 0;
	}

	@Override
	public List<Product> getProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product ", Product.class);
		List<Product> products = theQuery.getResultList();
		return products;
	}

}

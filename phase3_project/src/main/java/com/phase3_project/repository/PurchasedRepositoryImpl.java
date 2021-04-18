package com.phase3_project.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phase3_project.model.Product;
import com.phase3_project.model.purchased_db;
@Repository(value = "purchasedRepository")
public class PurchasedRepositoryImpl implements PurchasedRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<purchased_db> getByDate(String date) {
		
Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<purchased_db> theQuery = currentSession.createQuery("from purchased_db where  date='"+date+"'",purchased_db.class);
		
		// execute query
		List<purchased_db> purchased = theQuery.getResultList();
		
		return purchased;
	
	}

	@Override
	public List<purchased_db> getByCategory(String category) {
		Session currentSession = sessionFactory.getCurrentSession();

      Query<purchased_db> theQuery = currentSession.createQuery("from purchased_db where  category='"+category+"'",purchased_db.class);
		
		// execute query
		List<purchased_db> purchased = theQuery.getResultList();
		
		return purchased;
	}

}

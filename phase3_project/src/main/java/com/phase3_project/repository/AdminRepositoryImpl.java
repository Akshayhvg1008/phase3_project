package com.phase3_project.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phase3_project.model.Admin;
import com.phase3_project.model.Product;
@Repository(value = "adminRepository")
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int valid(String username, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Admin where username=:username and password=:password");
       theQuery.setParameter("username", username);
       theQuery.setParameter("password", password);
       Admin hari=(Admin)theQuery.uniqueResult();
       if(hari!=null)
    	   return 1;
else return 0;
       /* if(theQuery!=null)
       return 1;*/
	}
	

}

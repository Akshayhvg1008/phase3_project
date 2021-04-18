package com.phase3_project.repository;

import java.util.List;

import com.phase3_project.model.purchased_db;

public interface PurchasedRepository {
	
 
 List<purchased_db> getByDate(String date);
 List<purchased_db> getByCategory(String cateory);

}

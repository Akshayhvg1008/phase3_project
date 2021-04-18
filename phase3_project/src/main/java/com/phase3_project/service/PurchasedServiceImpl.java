package com.phase3_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phase3_project.model.purchased_db;
import com.phase3_project.repository.PurchasedRepository;
@Service(value = "purchasedService")
public class PurchasedServiceImpl implements PurchasedService {

	@Autowired
	private PurchasedRepository purchasedRepository;
	@Override
	@Transactional
	public List<purchased_db> getByDate(String date) {
		return purchasedRepository.getByDate(date);
	}

	@Override
	@Transactional
	public List<purchased_db> getByCategory(String cateory) {
		return purchasedRepository.getByCategory(cateory);
	}

}

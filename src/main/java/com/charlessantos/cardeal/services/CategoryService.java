package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Category;
import com.charlessantos.cardeal.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> returnValue = repo.findById(id);
		
		return returnValue.orElse(null);
	}
}

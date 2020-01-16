package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Category;
import com.charlessantos.cardeal.repositories.CategoryRepository;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> returnValue = repo.findById(id);
		
		return returnValue.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id:" + id + " TYPE: " + Category.class.getName()));
	}
}

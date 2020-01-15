package com.charlessantos.cardeal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlessantos.cardeal.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1, "SUV"));
		categories.add(new Category(2, "Hatch"));
		categories.add(new Category(3, "Sedan"));
		
		return categories; 
	}
}

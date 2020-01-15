package com.charlessantos.cardeal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.charlessantos.cardeal.domain.Category;
import com.charlessantos.cardeal.repositories.CategoryRepository;

@SpringBootApplication
public class CardealApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(CardealApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.saveAll(Arrays.asList(new Category(null, "SUV"), new Category(null, "Hatch"), new Category(null, "Sedan")));
		
	}

}

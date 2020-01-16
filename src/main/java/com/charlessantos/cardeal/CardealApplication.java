package com.charlessantos.cardeal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.charlessantos.cardeal.domain.Category;
import com.charlessantos.cardeal.domain.City;
import com.charlessantos.cardeal.domain.Product;
import com.charlessantos.cardeal.domain.State;
import com.charlessantos.cardeal.repositories.CategoryRepository;
import com.charlessantos.cardeal.repositories.CityRepository;
import com.charlessantos.cardeal.repositories.ProductRepository;
import com.charlessantos.cardeal.repositories.StateRepository;

@SpringBootApplication
public class CardealApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository prodRepository;
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CardealApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Category cat1 = new Category(null, "SUV");
		Category cat2 = new Category(null, "Hatch");
		Category cat3 = new Category(null, "Sedan");
		
		Product prod1 = new Product(null, "Tracker", 51D);
		Product prod2 = new Product(null, "Fox Prime", 31D);
		Product prod3 = new Product(null, "Fiat Argo", 37D);
		Product prod4 = new Product(null, "Jetta", 61D);
		Product prod5 = new Product(null, "Civic", 51D);
		Product prod6 = new Product(null, "Onix Plus", 55D);
		
		cat1.getProducts().add(prod1);
		cat2.getProducts().addAll(Arrays.asList(prod2, prod3));
		cat3.getProducts().addAll(Arrays.asList(prod4, prod5, prod6));
		
		prod1.getCategories().add(cat1);
		
		prod2.getCategories().add(cat2);
		prod3.getCategories().add(cat2);
		
		prod4.getCategories().add(cat3);
		prod5.getCategories().add(cat3);
		prod6.getCategories().add(cat3);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodRepository.saveAll(Arrays.asList(prod1,prod2, prod3, prod4, prod5, prod6));
		
		State state1 = new State(null, "Minas Gerais", "MG");
		
		City city1 = new City(null, "Belo Horizonte", state1);
		City city2 = new City(null, "Contagem", state1);
		City city3 = new City(null, "Santa Luzia", state1);
		
		state1.getCities().addAll(Arrays.asList(city1, city2, city3));
		
		stateRepo.save(state1);
		cityRepo.saveAll(Arrays.asList(city1, city2, city3));
	}

}

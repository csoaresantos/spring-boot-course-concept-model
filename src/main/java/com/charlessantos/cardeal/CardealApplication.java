package com.charlessantos.cardeal;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.charlessantos.cardeal.domain.Address;
import com.charlessantos.cardeal.domain.Car;
import com.charlessantos.cardeal.domain.Category;
import com.charlessantos.cardeal.domain.City;
import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.domain.ItemOrder;
import com.charlessantos.cardeal.domain.PaymentInBill;
import com.charlessantos.cardeal.domain.PaymentInCard;
import com.charlessantos.cardeal.domain.Product;
import com.charlessantos.cardeal.domain.PurchaseOrder;
import com.charlessantos.cardeal.domain.State;
import com.charlessantos.cardeal.domain.enums.StatusPayment;
import com.charlessantos.cardeal.domain.enums.TypeClient;
import com.charlessantos.cardeal.repositories.AddressRepository;
import com.charlessantos.cardeal.repositories.CategoryRepository;
import com.charlessantos.cardeal.repositories.CityRepository;
import com.charlessantos.cardeal.repositories.ClientRepository;
import com.charlessantos.cardeal.repositories.ItemOrderRepository;
import com.charlessantos.cardeal.repositories.PaymentRepository;
import com.charlessantos.cardeal.repositories.ProductRepository;
import com.charlessantos.cardeal.repositories.PurchaseOrderRepository;
import com.charlessantos.cardeal.repositories.StateRepository;
import com.charlessantos.cardeal.repositories.VehicleRepository;

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
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	PurchaseOrderRepository orderRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	ItemOrderRepository itemOrderRepo;
	
	@Autowired
	VehicleRepository vehicleRepo;
	
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
		
		
		Client cli1 = new Client(null, "Vando Quirino", "vando@gmail.com", "00000000000", TypeClient.PHYSICALPERSON);
		cli1.getTelephones().addAll(Arrays.asList("3124480844", "3113460834"));
		
		Address addr1 = new Address(null, "Rua um", "1113A", "No complement", "Mangabeira", "31678489", cli1, city1);
		Address addr2 = new Address(null, "Rua três", "13A", "No complement", "California", "31678489", cli1, city2);
		
		clientRepo.saveAll(Arrays.asList(cli1));
		addressRepo.saveAll(Arrays.asList(addr1, addr2));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		PurchaseOrder order1 = new PurchaseOrder(null, dateFormat.parse("30/09/2018 10:30"),cli1, addr1);
		PurchaseOrder order2 = new PurchaseOrder(null, dateFormat.parse("10/10/2020 17:13"),cli1, addr2);
		
		PaymentInCard paymentCredit = new PaymentInCard(null, StatusPayment.PAID, order1, 6);
		order1.setPayment(paymentCredit);
		
		PaymentInBill paymentBill = new PaymentInBill(null, StatusPayment.PENDING, order2, dateFormat.parse("20/10/2020 12:15"), null);
		order2.setPayment(paymentBill);
		
		cli1.getPurchaseOrders().addAll(Arrays.asList(order1, order2));
		
		orderRepo.saveAll(Arrays.asList(order1, order2));
		
		paymentRepo.saveAll(Arrays.asList(paymentCredit, paymentBill));
		
		
		ItemOrder ip1 = new ItemOrder(prod1, order1,0.00, 1, 2000.00);
		ItemOrder ip2 = new ItemOrder(prod3, order1,0.00, 1, 8000.00);
		
		order1.getItems().addAll(Arrays.asList(ip1, ip2));
		order2.getItems().add(ip2);
		
		prod1.getItems().addAll(Arrays.asList(ip1));
		prod3.getItems().add(ip2);
		
		itemOrderRepo.saveAll(Arrays.asList(ip1, ip2));
		
		Car vehicle = new Car(null, "OQE2200", "VolksWagen", "Hatch", 2013, 2013, "PRIME", "1.6", "16", "5", "Vermelho", "Flex", "76.000");
		vehicleRepo.save(vehicle);
	}

}

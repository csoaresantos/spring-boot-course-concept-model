package com.charlessantos.cardeal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlessantos.cardeal.repositories.VehicleRepository;

@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	
	@Autowired
	VehicleRepository vehicleRepo;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		return ResponseEntity.ok(vehicleRepo.findById(id));
	}
}

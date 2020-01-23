package com.charlessantos.cardeal.resources;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.charlessantos.cardeal.domain.Car;
import com.charlessantos.cardeal.domain.Vehicle;
import com.charlessantos.cardeal.dto.VehicleDTO;
import com.charlessantos.cardeal.services.VehicleService;

@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	
	@Autowired
	VehicleService vehicleService;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Vehicle> find(@PathVariable Integer id) {
		return ResponseEntity.ok(vehicleService.find(id));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Car vehicle) {
		Vehicle newVehicle = vehicleService.save(vehicle);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newVehicle.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Car vehicle, @PathVariable Integer id) {
		vehicleService.update(vehicle);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		vehicleService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VehicleDTO>> findAll() {
		List<Vehicle> vehicles = vehicleService.findAll();
		List<VehicleDTO> vehiclesDTO = vehicles.stream().map(o -> new VehicleDTO(o)).collect(Collectors.toList());
		return ResponseEntity.ok(vehiclesDTO);
	}
}

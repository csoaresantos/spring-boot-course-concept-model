package com.charlessantos.cardeal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Car;
import com.charlessantos.cardeal.domain.Vehicle;
import com.charlessantos.cardeal.repositories.VehicleRepository;
import com.charlessantos.cardeal.services.exceptions.DataIntegrityException;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepo;
	
	public Vehicle find(Integer id) {
		Optional<Vehicle> obj = vehicleRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado nenhum veículo com o id: " + id));
	}
	
	public Car save(Car vehicle) {
		vehicle.setId(null);
		return vehicleRepo.save(vehicle);
	}

	public Car update(Car vehicle) {
		find(vehicle.getId());
		return vehicleRepo.save(vehicle);
	}
	
	public void delete(Integer vehicle) {
		find(vehicle);
		try {
			vehicleRepo.deleteById(vehicle);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não foi possível deletar item porque possui uma associação.", ex);
		}
	}
	
	public List<Vehicle> findAll() {
		return vehicleRepo.findAll();
	}

	public Page<Vehicle> findByPage(Integer pageIndice, Integer linesPerPage, String direction, String orderBy) {
		PageRequest page = PageRequest.of(pageIndice, linesPerPage, Direction.valueOf(direction), orderBy);
		return vehicleRepo.findAll(page);
	}
}

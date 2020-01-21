package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Vehicle;
import com.charlessantos.cardeal.repositories.VehicleRepository;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepo;
	
	public Vehicle find(Integer id) {
		Optional<Vehicle> obj = vehicleRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado nenhum veículo com o id: " + id));
	}

}

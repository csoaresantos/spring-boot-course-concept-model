package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.repositories.ClientRepository;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	public Client find(Integer id) {
		Optional<Client> returnValue = clientRepository.findById(id);
		return returnValue.orElseThrow(() -> new ObjectNotFoundException("Invalid id: " + id));
	}
}

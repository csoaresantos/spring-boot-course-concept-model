package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.domain.enums.TypeClient;
import com.charlessantos.cardeal.dto.ClientDTO;
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

	public Client save(Client client) {
		client.setId(null);
		return clientRepository.save(client);
	}

	public Client update(Client client) {
		Client oldClient = find(client.getId());
		Client newClient = mergePropertyValues(client, oldClient);
		return clientRepository.save(newClient);
	}

	public void delete(Integer id) {
		Client client = find(id);

		try {
			clientRepository.delete(client);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível deletar o client porque possui uma associação.");
		}
	}

	public Page<Client> findPage(Integer page, Integer size, String direction, String orderBy) {
		PageRequest client = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return clientRepository.findAll(client);
	}

	public Client fromDTO(ClientDTO clientDTO) {
		return new Client(clientDTO.getId(), clientDTO.getName(), clientDTO.getEmail(), "000000", TypeClient.LEGALPERSON);
	}

	private Client mergePropertyValues(Client newClient, Client oldClient) {
		oldClient.setName(newClient.getName());
		oldClient.setEmail(newClient.getEmail());
		
		return oldClient;
	}
}
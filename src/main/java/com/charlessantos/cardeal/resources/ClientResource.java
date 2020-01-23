package com.charlessantos.cardeal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Client> find(@PathVariable Integer id) {
		Client cli = clientService.find(id);
		return ResponseEntity.ok().body(cli);
	}
}

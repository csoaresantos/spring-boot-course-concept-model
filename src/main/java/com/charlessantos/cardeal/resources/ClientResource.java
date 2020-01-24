package com.charlessantos.cardeal.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.dto.ClientDTO;
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

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody ClientDTO clientDTO) {
		Client client = clientService.fromDTO(clientDTO);
		Client newClient = clientService.save(client);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Integer id) {
		Client client = clientService.fromDTO(clientDTO);
		clientService.update(client);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/id", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ClientDTO>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="size", defaultValue="24") Integer size, 
			@RequestParam(value="direction", defaultValue="ASC") String direction, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy) {

		Page<Client> client = clientService.findPage(page, size, direction, orderBy);
		Page<ClientDTO> clientDTO = client.map(converter -> new ClientDTO(converter));
		
		return ResponseEntity.ok(clientDTO);
	}


}
package com.charlessantos.cardeal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charlessantos.cardeal.domain.PurchaseOrder;
import com.charlessantos.cardeal.services.PurchaseOrderService;

@RestController
@RequestMapping(value="/purchaseOrder")
public class PurchaseOrderResource {

	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> find(@PathVariable Integer id) {
		return ResponseEntity.ok(purchaseOrderService.find(id));
	}
}

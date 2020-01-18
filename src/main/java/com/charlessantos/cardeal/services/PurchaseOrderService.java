package com.charlessantos.cardeal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.PurchaseOrder;
import com.charlessantos.cardeal.repositories.PurchaseOrderRepository;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository purchaseOrderRepo;
	
	public PurchaseOrder find(Integer id) {
		Optional<PurchaseOrder> obj = purchaseOrderRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Purchase order not found to id: " + id));
	}
}

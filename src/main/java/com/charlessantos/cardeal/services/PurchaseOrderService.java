package com.charlessantos.cardeal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charlessantos.cardeal.domain.ItemOrder;
import com.charlessantos.cardeal.domain.PaymentInBill;
import com.charlessantos.cardeal.domain.PurchaseOrder;
import com.charlessantos.cardeal.domain.enums.StatusPayment;
import com.charlessantos.cardeal.repositories.ItemOrderRepository;
import com.charlessantos.cardeal.repositories.PaymentRepository;
import com.charlessantos.cardeal.repositories.ProductRepository;
import com.charlessantos.cardeal.repositories.PurchaseOrderRepository;
import com.charlessantos.cardeal.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository purchaseOrderRepo;
	
	@Autowired
	BillService billService;

	@Autowired
	PaymentRepository paymentRepo;

	@Autowired
	ProductRepository prodRepo;

	@Autowired
	ItemOrderRepository itemOrderRepo;

	public PurchaseOrder find(Integer id) {
		Optional<PurchaseOrder> obj = purchaseOrderRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Purchase order not found to id: " + id));
	}

	@Transactional
	public PurchaseOrder insert(PurchaseOrder order) {
		order.setId(null);
		order.setInstant(new Date());
		order.getPayment().setStatus(StatusPayment.PENDING);
		order.getPayment().setPurchaseOrder(order);

		if(order.getPayment() instanceof PaymentInBill) {
			PaymentInBill bill = (PaymentInBill) order.getPayment();
			billService.fillPaymentInBillDueDate(bill, order.getInstant());
		}

		paymentRepo.save(order.getPayment());
		
		for(ItemOrder x : order.getItems()) {
			x.setDiscount(0D);
			x.setPrice(prodRepo.findById(x.getProduct().getId()).get().getPrice());
			x.setPurchaseOrder(order);
		}

		itemOrderRepo.saveAll(order.getItems());
		
		return purchaseOrderRepo.save(order);
	}
}

package com.charlessantos.cardeal.domain;

import javax.persistence.Entity;

import com.charlessantos.cardeal.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentInCard")
public class PaymentInCard extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;

	public PaymentInCard() {
	}

	public PaymentInCard(Integer id, StatusPayment status, PurchaseOrder purchaseOrder, Integer numberOfInstallments) {
		super(id, status, purchaseOrder);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
}

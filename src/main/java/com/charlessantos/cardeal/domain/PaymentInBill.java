package com.charlessantos.cardeal.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.charlessantos.cardeal.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentInBill")
public class PaymentInBill extends Payment {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date payDay;
	
	public PaymentInBill() {
	}
	
	public PaymentInBill(Integer id, StatusPayment status, PurchaseOrder purchaseOrder, Date dueDate, Date payDay) {
		super(id, status, purchaseOrder);
		this.dueDate = dueDate;
		this.payDay = payDay;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getPayDay() {
		return payDay;
	}
	
	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

}

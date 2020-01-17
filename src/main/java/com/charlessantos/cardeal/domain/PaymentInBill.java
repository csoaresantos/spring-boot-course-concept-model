package com.charlessantos.cardeal.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.charlessantos.cardeal.domain.enums.StatusPayment;

@Entity
public class PaymentInBill extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payDay;
	
	public PaymentInBill() {
	}
	
	public PaymentInBill(Integer id, StatusPayment status, Invoice invoice, Date dueDate, Date payDay) {
		super(id, status, invoice);
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

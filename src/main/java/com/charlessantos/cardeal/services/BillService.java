package com.charlessantos.cardeal.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.charlessantos.cardeal.domain.PaymentInBill;

@Service
public class BillService {
	public void fillPaymentInBillDueDate(PaymentInBill bill, Date duedate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(duedate);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		bill.setDueDate(cal.getTime());
	}
}

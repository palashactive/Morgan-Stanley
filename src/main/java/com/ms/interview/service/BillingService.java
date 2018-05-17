package com.ms.interview.service;

import java.util.List;

import com.ms.interview.entity.Billing;

public interface BillingService {
	
	public Iterable<Billing> saveBill(List<Billing> medicineBilling);
}

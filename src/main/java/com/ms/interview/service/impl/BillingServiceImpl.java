package com.ms.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.interview.entity.Billing;
import com.ms.interview.repository.BillingRepository;
import com.ms.interview.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepository billingRepository;
	
	@Override
	public Iterable<Billing> saveBill(List<Billing> medicineBilling) {
	
		return billingRepository.save(medicineBilling);
	}

}

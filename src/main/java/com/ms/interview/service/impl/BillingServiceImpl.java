package com.ms.interview.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.interview.entity.Billing;
import com.ms.interview.repository.BillingRepository;
import com.ms.interview.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepository billingRepository;
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public Iterable<Billing> saveBill(List<Billing> medicineBilling) {
	
		return billingRepository.save(medicineBilling);
	}
	
	@Override
	public List<Billing> getBillingHistory(String invoiceNo){
		return billingRepository.findByBillingIdInvoiceNo(invoiceNo);
	}
	
	@Override
	public List<String> getTopMedicines(){
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		List<Billing> medQuantitySoldList = em.createQuery("select medicineid, sum(quantity) from billing group by medicineid").getResultList();
		Collections.sort(medQuantitySoldList, Collections.reverseOrder());
		
		List<String> topMedicines = new ArrayList<>();
		for(Billing bill:medQuantitySoldList) {
			topMedicines.add(bill.getBillingId().getMedicineId());
		}
		return topMedicines.subList(0, 9);
	}
}

package com.ms.interview.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ms.interview.entity.Billing;
import com.ms.interview.entity.BillingId;

public interface BillingRepository extends CrudRepository<Billing,BillingId>{

	List<Billing> findByBillingIdInvoiceNo(String invoiceNo);
}

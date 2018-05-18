package com.ms.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.interview.entity.Billing;
import com.ms.interview.entity.BillingId;

public interface BillingRepository extends CrudRepository<Billing,BillingId>{

	List<Billing> findByBillingIdInvoiceNo(String invoiceNo);
	
	/*@Query("select TopMedicines.medicine_id from (select medicine_id from (select medicine_id, sum(quantity) as totalQuantity from billing group by medicine_id) as MedQuantity order by totalQuantity desc) as TopMedicines LIMIT 10")
	List<String> findTopMedicines();*/
}

package com.ms.interview.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.interview.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, String>{

}

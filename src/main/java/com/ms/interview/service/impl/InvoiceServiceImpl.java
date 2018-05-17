package com.ms.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.interview.entity.Invoice;
import com.ms.interview.repository.InvoiceRepository;
import com.ms.interview.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

}

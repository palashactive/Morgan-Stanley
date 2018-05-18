package com.ms.interview.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Invoice {
	
	@Id
	private String invoiceNo;
	
	private Date invoiceDate;
	
	private double billingAmount;
	
	@OneToMany(mappedBy="invoice")
	private List<Billing> medicineBilling = new ArrayList<>();

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public List<Billing> getMedicineBilling() {
		return medicineBilling;
	}

	public void setMedicineBilling(List<Billing> medicineBilling) {
		this.medicineBilling = medicineBilling;
	}
}

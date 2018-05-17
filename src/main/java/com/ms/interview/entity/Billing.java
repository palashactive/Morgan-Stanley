package com.ms.interview.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Billing {
	
	@EmbeddedId
	private BillingId billingId;
	
	private Integer quantity;
	
	@ManyToOne
    //@JoinColumn(name = "invoiceNo", referencedColumnName = "invoiceNo")
    private Invoice invoice;
	
	@ManyToOne
	private MedicineData medicineData;

	public BillingId getBillingId() {
		return billingId;
	}

	public void setBillingId(BillingId billingId) {
		this.billingId = billingId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}

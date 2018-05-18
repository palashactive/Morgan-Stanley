package com.ms.interview.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Billing {
	
	@EmbeddedId
	private BillingId billingId;
	
	private Integer quantity;
	
	@ManyToOne
    @JoinColumn(name = "invoiceno", referencedColumnName = "invoiceno", insertable=false,updatable=false)
    private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "medicineid", referencedColumnName = "id", insertable=false,updatable=false)
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

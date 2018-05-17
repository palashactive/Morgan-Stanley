package com.ms.interview.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BillingId implements Serializable {

	@NotNull
	private String invoiceNo;
	
	@NotNull
	private String medicineId;
	
	public BillingId() {
		
	}

	public BillingId(String invoiceNo, String medicineId) {
		super();
		this.invoiceNo = invoiceNo;
		this.medicineId = medicineId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceNo == null) ? 0 : invoiceNo.hashCode());
		result = prime * result + ((medicineId == null) ? 0 : medicineId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingId other = (BillingId) obj;
		if (invoiceNo == null) {
			if (other.invoiceNo != null)
				return false;
		} else if (!invoiceNo.equals(other.invoiceNo))
			return false;
		if (medicineId == null) {
			if (other.medicineId != null)
				return false;
		} else if (!medicineId.equals(other.medicineId))
			return false;
		return true;
	}
}

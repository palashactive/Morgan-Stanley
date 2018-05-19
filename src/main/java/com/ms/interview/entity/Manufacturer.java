package com.ms.interview.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manufacturer {

	@Id
	private String manufacturerId;
	
	private String manfacturerName;
	
	private boolean isBlocked;

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManfacturerName() {
		return manfacturerName;
	}

	public void setManfacturerName(String manfacturerName) {
		this.manfacturerName = manfacturerName;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
}

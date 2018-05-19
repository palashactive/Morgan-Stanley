package com.ms.interview.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer {

	@Id
	private String manufacturerId;
	
	private String manfacturerName;
	
	private boolean isBlocked;
	
	@OneToMany(mappedBy="medManufacturer")
	List<MedicineData> medicineDataList = new ArrayList<>();

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

	public List<MedicineData> getMedicineDataList() {
		return medicineDataList;
	}

	public void setMedicineDataList(List<MedicineData> medicineDataList) {
		this.medicineDataList = medicineDataList;
	}
}

package com.ms.interview.service;

import java.util.List;

import com.ms.interview.entity.MedicineData;

public interface MedicineDataService {

	// Get all medicines details
	public Iterable<MedicineData> getAllMedicine();

	// Get a medicine by its product Id
	public MedicineData getMedicineById(String id);

	// Get medicine by Name/Generic Name/Category
	public List<MedicineData> getMedicines(String name, String attribute);

	// Save medicines
	public Iterable<MedicineData> saveAll(List<MedicineData> medicineDataList);

	// Save/Update a medicine
	public MedicineData saveMedicine(MedicineData medicineData);

	// Get a medicine by brand name
	public MedicineData getMedicineByBrandName(MedicineData medicineData);
}

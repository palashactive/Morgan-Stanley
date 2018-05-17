package com.ms.interview.service;

import java.util.List;

import com.ms.interview.entity.MedicineData;

public interface MedicineDataService {

	public Iterable<MedicineData> getAllMedicine();
	
	public MedicineData getMedicineById(String id);
	
	public List<MedicineData> getMedicines(String name, String attribute);
	
	public Iterable<MedicineData> saveAll(List<MedicineData> medicineDataList);
	
	public MedicineData saveMedicine(MedicineData medicineData);
	
	public MedicineData getMedicineByBrandName(MedicineData medicineData);
}

package com.ms.interview.service;

import java.util.List;

import com.ms.interview.entity.MedicineData;

public interface MedicineDataService {

	public Iterable<MedicineData> getAllMedicine();
	
	public MedicineData getMedicineById(String id);
	
	public Iterable<MedicineData> setup(List<MedicineData> medicineDataList);
	
	public MedicineData saveMedicine(MedicineData medicineData);
}

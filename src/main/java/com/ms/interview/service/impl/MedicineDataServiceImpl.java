package com.ms.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.interview.entity.MedicineData;
import com.ms.interview.repository.MedicineDataRepository;
import com.ms.interview.service.MedicineDataService;

@Service
public class MedicineDataServiceImpl implements MedicineDataService {
	
	@Autowired // This means to get the bean called medicineDataRepository
	private MedicineDataRepository medicineDataRepository;
	
	@Override
	public Iterable<MedicineData> getAllMedicine() {

		return medicineDataRepository.findAll();
	}

	@Override
	public MedicineData getMedicineById(String id) {

		return medicineDataRepository.findOne(id);
	}
	
	@Override
	public Iterable<MedicineData> setup(List<MedicineData> medicineDataList){
		
		return medicineDataRepository.save(medicineDataList);
	}
	
	@Override
	public MedicineData saveMedicine(MedicineData medicineData) {
		
		return medicineDataRepository.save(medicineData);
	}

}

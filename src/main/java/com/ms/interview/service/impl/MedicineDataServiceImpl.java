package com.ms.interview.service.impl;

import java.util.ArrayList;
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
	public List<MedicineData> getAllMedicine() {

		List<MedicineData> medListAll = medicineDataRepository.findAll();
		List<MedicineData> medByNameWhiteList = getWhiteListedMedicineList(medListAll);
		return medByNameWhiteList;
	}

	@Override
	public MedicineData getMedicineById(String id) {

		return medicineDataRepository.findOne(id);
	}

	@Override
	public Iterable<MedicineData> saveAll(List<MedicineData> medicineDataList) {

		return medicineDataRepository.save(medicineDataList);
	}

	@Override
	public MedicineData saveMedicine(MedicineData medicineData) {

		return medicineDataRepository.save(medicineData);
	}

	@Override
	public List<MedicineData> getMedicines(String attributeValue, String attribute) {

		if (attribute.equals("Name")) {
			
			List<MedicineData> medListByName = medicineDataRepository.findByName(attributeValue);
			List<MedicineData> medByNameWhiteList = getWhiteListedMedicineList(medListByName);
			return medByNameWhiteList;
		}

		else if (attribute.equals("GenericName")) {
			List<MedicineData> medListByGenericName = medicineDataRepository.findByGenericName(attributeValue);
			List<MedicineData> medByNameWhiteList = getWhiteListedMedicineList(medListByGenericName);
			return medByNameWhiteList;
		}

		else if (attribute.equals("Category")) {
			List<MedicineData> medListByCategory = medicineDataRepository.findByCategory(attributeValue);
			List<MedicineData> medByNameWhiteList = getWhiteListedMedicineList(medListByCategory);
			return medByNameWhiteList;
		}

		return null;
	}
	
	@Override
	public MedicineData getMedicineByBrandName(MedicineData medicineData) {
		MedicineData medicineDb = medicineDataRepository.findByNameAndManufacturer(medicineData.getName(), medicineData.getManufacturer());
		MedicineData whiteListMed = getWhiteListedMedicines(medicineDb);
		return whiteListMed;
	}
	
	private List<MedicineData> getWhiteListedMedicineList(List<MedicineData> medList){
		List<MedicineData> medByNameWhiteList = new ArrayList<>();
		for(MedicineData med : medList){
			
			MedicineData whiteListMed = getWhiteListedMedicines(med);
			if(whiteListMed != null)
				medByNameWhiteList.add(whiteListMed);
		}
		return medByNameWhiteList;
	}
	private MedicineData getWhiteListedMedicines(MedicineData medData) {
		
		if(!medData.getMedManufacturer().isBlocked()) {
			return medData;
		}
		else
			return null;
	}
}

package com.ms.interview.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.interview.entity.MedicineData;
import com.ms.interview.service.MedicineDataService;

@Controller
@RequestMapping(path = "/test") // This means URL's start with /test (after Application path)
public class MainController {

	@Autowired
	MedicineDataService medicineDataService;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewMedicine(@RequestBody MedicineData medicineData) {

		MedicineData savedMedicine = medicineDataService.saveMedicine(medicineData);
		if (savedMedicine != null)
			return "Saved";
		else
			return "Error";
	}

	@PostMapping(path = "/buy")
	public @ResponseBody String addNewMedicine(@RequestBody List<MedicineData> buyMedicineData) {

		boolean buySuccess = false;
		List<MedicineData> updatedMedicineDataList = new ArrayList<>();
		for(MedicineData medData : buyMedicineData) {

			MedicineData medicineDataDB = null;
			medicineDataDB = medicineDataService.getMedicineByBrandName(medData);

			if (medicineDataDB != null) {
				
				if(medicineDataDB.getQuantity() >= medData.getQuantity()) {
					buySuccess = true;
					medicineDataDB.setQuantity(medicineDataDB.getQuantity() - medData.getQuantity());
					updatedMedicineDataList.add(medicineDataDB);
				}
				else {
					updatedMedicineDataList.clear();
					buySuccess = false;
					break;
				}
			} else {
				updatedMedicineDataList.clear();
				buySuccess = false;
				break;
			}
		}

		if(buySuccess) {
			
			medicineDataService.saveAll(updatedMedicineDataList);
			return "Invoice : 1234";
		}
		else {
			return "Medicine quantity not available";
		}
	}

	@PostMapping(path = "/setup")
	public @ResponseBody Iterable<MedicineData> setup(@RequestBody List<MedicineData> setupData) {

		return medicineDataService.saveAll(setupData);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<MedicineData> getAllMedicines() {
		return medicineDataService.getAllMedicine();
	}

	@GetMapping(path = "/getMedicineByName")
	public @ResponseBody List<MedicineData> getMedicinesByName(@RequestParam String name) {
		return medicineDataService.getMedicines(name, "Name");
	}

	@GetMapping(path = "/getMedicineByGenericName")
	public @ResponseBody List<MedicineData> getMedicinesByGenericName(@RequestParam String genericName) {
		return medicineDataService.getMedicines(genericName, "GenericName");
	}

	@GetMapping(path = "/getMedicineByCategory")
	public @ResponseBody List<MedicineData> getMedicinesByCategory(@RequestParam String category) {
		return medicineDataService.getMedicines(category, "Category");
	}
}

package com.ms.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.interview.entity.MedicineData;
import com.ms.interview.repository.MedicineDataRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/test") // This means URL's start with /test (after Application path)
public class MainController {
	@Autowired // This means to get the bean called medicineDataRepository
	private MedicineDataRepository medicineDataRepository;
	
	@PostMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (MedicineData medicineData) {
		
		medicineDataRepository.save(medicineData);
		return "Saved";
	}
	
	@PostMapping(path="/setup") // Map ONLY POST Requests
	public @ResponseBody List<MedicineData> setup (@RequestBody List<MedicineData> setupData) {
		
		medicineDataRepository.save(setupData);
		return setupData;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<MedicineData> getAllMedicines() {
		// This returns a JSON or XML all medicine
		return medicineDataRepository.findAll();
	}

}

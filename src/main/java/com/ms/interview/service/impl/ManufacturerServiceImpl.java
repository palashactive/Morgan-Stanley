package com.ms.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.interview.entity.Manufacturer;
import com.ms.interview.repository.ManufacturerRepository;
import com.ms.interview.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Override
	public boolean blackListManufacturer(String manufacturerId) {
		
		Manufacturer manufacturerDB = manufacturerRepository.findOne(manufacturerId);
		
		if(manufacturerDB != null) {
			manufacturerDB.setBlocked(true);
			manufacturerRepository.save(manufacturerDB);
			return true;
		}
		
		return false;
	}

}

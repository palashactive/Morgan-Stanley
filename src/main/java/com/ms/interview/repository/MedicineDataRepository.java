package com.ms.interview.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.interview.entity.MedicineData;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MedicineDataRepository extends CrudRepository<MedicineData, String> {

}

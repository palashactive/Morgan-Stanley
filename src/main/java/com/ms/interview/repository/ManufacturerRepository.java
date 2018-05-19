package com.ms.interview.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.interview.entity.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, String> {

}

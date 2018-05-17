package com.thoughtworks.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.thoughtworks.test.entity.User1;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User1, Long> {

}

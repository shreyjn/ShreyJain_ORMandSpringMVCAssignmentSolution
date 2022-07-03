package com.greatLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.entity.Customer;

@Repository

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

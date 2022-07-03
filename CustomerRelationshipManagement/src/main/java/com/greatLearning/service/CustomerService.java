package com.greatLearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.entity.Customer;
import com.greatLearning.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo repo;

	public void addCustomer(Customer c) {

		repo.save(c);
	}

	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	public Customer getCustomerById(int id) {

		Optional<Customer> c = repo.findById(id);
		if (c.isPresent()) {
			return c.get();
		}
		return null;
	}

	public void deleteCustomer(int id) {

		repo.deleteById(id);
	}

}

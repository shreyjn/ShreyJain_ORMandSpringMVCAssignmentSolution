package com.greatLearning.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatLearning.entity.Customer;
import com.greatLearning.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public String home(Model m) {
		List<Customer> cusList = service.getAllCustomer();
		m.addAttribute("cusList", cusList);
		return "index";
	}

	@GetMapping("/add_customer")
	public String addCustomerForm() {
		return "add_customer";
	}

	@PostMapping("/register")
	public String customerRegister(@ModelAttribute Customer c, HttpSession session) {
		service.addCustomer(c);
		session.setAttribute("msg", "Customer Added Successfully!!!");
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String edit(@PathVariable int id, Model m) {
		Customer c = service.getCustomerById(id);
		m.addAttribute("customer", c);

		return "update";
	}

	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute Customer c, HttpSession session) {
		service.addCustomer(c);
		session.setAttribute("msg", "Data Updated Successfully...");
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id, HttpSession session) {
		service.deleteCustomer(id);
		session.setAttribute("msg", "Customer Deleted Successfully...");
		return "redirect:/";
	}
}
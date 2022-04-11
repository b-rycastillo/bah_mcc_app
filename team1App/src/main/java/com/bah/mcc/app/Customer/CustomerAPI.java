package com.bah.mcc.app.Customer;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public CustomerAPI() {
		Customer c1 = new Customer(1, "Lauren", "lauren@gmail.com");
		Customer c2 = new Customer(2, "Tony", "tony@gmail.com");
		Customer c3 = new Customer(3, "Maria", "maria@gmail.com");
		Customer c4 = new Customer(4, "Bob", "bob@gmail.com");
		
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);
	}
	
	@GetMapping
	public Collection<Customer> getAll(){
		return this.customerList;
	}
	
	@GetMapping("/id/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		Customer customer = null;
		for (int i = 0 ; i < customerList.size(); i++) {
			if(customerList.get(i).getId() == id) {
				customer = customerList.get(i);
			}
		}
		return customer;
	}
	
}

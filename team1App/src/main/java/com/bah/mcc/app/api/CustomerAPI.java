package com.bah.mcc.app.api;

import java.net.URI;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.app.domain.Customer;
//import com.webage.logging.ApiLogger;
import com.bah.mcc.app.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	@Autowired
	CustomersRepository repo;

	@GetMapping
	public Iterable<Customer> getAll() {
		//  Workshop:  Write an implementation that replies with all customers.
		//  Your implementation should be no more than a few lines, at most, and make use of the 'repo' object
		return repo.findAll();
	}

	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") long id) {
		//  Workshop:  Write an implementation that looks up one customer.  What do you return if the requested 
		//  customer ID does not exists?  This implementation could be as short as a single line.
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		//  Workshop:  Write an implementation that adds a new customer.  Your
		//  implementation should check to make sure that the name and email fields are
		//  not null and that no id was passed (it will be auto generated when the record
		//  is inserted.  Remember REST semantics - return a reference to the newly created 
		//  entity as a URI.
		if (newCustomer.getId() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri(); 
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	//lookupCustomerByName GET
	@GetMapping("/byname/{username}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("username") String username, UriComponentsBuilder uri) {
		//  Workshop:  Write an implementation to look up a customer by name.  Think about what
		//  your response should be if no customer matches the name the caller is searching for.
		//  With the data model implemented in CustomersRepository, do you need to handle more than
		//  one match per request?
//		invalid[] foundCustomer = {null};
//		repo.findAll().forEach(customer -> {
//			if (customer.getName().equalsIgnoreCase(username)) {
//				foundCustomer = customer;
//			}
//		});

		return null;
	}
	
	//lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String username, UriComponentsBuilder uri) {
		//  Workshop:  Write an implementation to look up a customer by name, using POST semantics
		//  rather than GET.  You should be able to make use of most of your implmentation for
		//  lookupCustomerByNameGet().  
		return null;
	}	
	
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer( @RequestBody Customer newCustomer, @PathVariable("customerId") long customerId) {
		//  Workshop:  Write an implementation to update or create a new customer with an HTTP PUT, with the 
		//  requestor specifying the customer ID.  Are there error conditions to be handled?  How much data
		//  validation should you implement considering that customers are stored in a CustomersRepository object.
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		Optional<Customer> customerToDelete = repo.findById(id);
		if(customerToDelete != null) {
			 repo.deleteById(id);
			 return ResponseEntity.noContent().build();
			 
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}	
}

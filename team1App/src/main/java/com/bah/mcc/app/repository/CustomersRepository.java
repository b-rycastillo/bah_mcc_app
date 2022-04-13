package com.bah.mcc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.app.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}

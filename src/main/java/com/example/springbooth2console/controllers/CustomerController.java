package com.example.springbooth2console.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbooth2console.entities.Customer;
import com.example.springbooth2console.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    public ResponseEntity<Customer> addClient(@RequestBody Customer c) {
    	Customer cust = new Customer(c.id, c.firstName, c.lastName, c.cin, c.age);
    	customerRepository.save(cust);
        return new ResponseEntity<>(cust, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/List/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }
    
    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public Customer updateClient(@RequestBody Customer c) {
        return customerRepository.saveAndFlush(c);
    }

}

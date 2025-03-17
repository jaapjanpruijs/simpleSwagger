package com.example.accessingdatajpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("setCustomer")
    public Customer setCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("listCustomers")
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}

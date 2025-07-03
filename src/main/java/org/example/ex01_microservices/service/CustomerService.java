package org.example.ex01_microservices.service;

import org.example.ex01_microservices.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CustomerService {

    public static void main(String[] args) {
        SpringApplication.run(CustomerService.class, args);
    }

    public List<Customer> getAll() {
    }

    public Customer getCustomerById(Integer id) {
        return null;
    }

    public Customer create(Customer customer) {
        return null;
    }
}

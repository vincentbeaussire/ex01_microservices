package org.example.ex01_microservices.controller;

import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Order;
import org.example.ex01_microservices.model.Product;
import org.example.ex01_microservices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate, CustomerService customerService) {
        this.restTemplate = restTemplate;
        this.customerService = customerService;
    }
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }



    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Dupont");
        Order order = restTemplate.getForObject(
                "http://ORDER/customer/{id}",
                Order.class,
                id
        );
        customer.setOrder(order);
        return customer;
    }
}

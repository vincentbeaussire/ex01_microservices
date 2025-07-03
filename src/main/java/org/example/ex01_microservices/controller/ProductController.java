package org.example.ex01_microservices.controller;

import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Order;
import org.example.ex01_microservices.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final RestTemplate restTemplate;

    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){

        Product product = new Product();
        product.setId(id);
        product.setName("Pc Portable");
        product.setPrice(999.99);
        Order order = restTemplate.getForObject(
                "http://ORDER/product/{id}",
                Order.class,
                id
        );
        product.setOrder(order);
        return product;
    }
}

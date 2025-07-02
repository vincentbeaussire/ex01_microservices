package org.example.ex01_microservices.controller;


import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Order;
import org.example.ex01_microservices.model.Product;
import org.example.ex01_microservices.util.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable int id){
        Order order = new Order();
        order.setId(id);
        order.setDescription("New MacBook Pro 1to");
        Product product = restTemplate.getForObject(
                "http://localhost:8081/product/{id}",
                Product.class,
                id
        );
        order.setProduct(String.valueOf(product));
        return order;
    }

    @GetMapping("/detailorder/{id}")
    public Order getCommande (@PathVariable int id){
        Order order= new Order();
        order.setId(id);
        order.setDescription("New MacBook Pro 1to");
        RestClient<Product> productRestClient = new RestClient<>("http://localhost:8081/products/1");
        Product product = productRestClient.get(Product.class);
        order.setProduct(String.valueOf(product));
        return order;
    }



    @GetMapping("/customer/{id}")
    public Order getCustomer(@PathVariable int id){
        Order order = new Order();
        order.setId(id);
        order.setCustomer("Mr Dupont");
        Customer customer = restTemplate.getForObject(
                "http://localhost:8082/customer/{id}",
                Customer.class,
                id
        );
        order.setCustomer(String.valueOf(customer));
        return order;
    }

    @GetMapping("/detailcustomer/{id}")
    public Order getClient (@PathVariable int id){
        Order order= new Order();
        order.setId(id);
        order.setCustomer("Mr Dupont");
        RestClient<Customer> customerRestClient = new RestClient<>("http://localhost:8082/customers/1");
        Customer customer = customerRestClient.get(Customer.class);
        order.setCustomer(String.valueOf(customer));
        return order;
    }
}

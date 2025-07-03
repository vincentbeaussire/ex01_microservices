package org.example.ex01_microservices.service;

import org.example.ex01_microservices.dto.OrderResponseDto;
import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Order;
import org.example.ex01_microservices.model.Product;
import org.example.ex01_microservices.util.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order getOrderById(int id){
        return new Order(id,"ma commande pour les vacances",2,5);
    }

    public OrderResponseDto orderToOrderResponseDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDescription(order.getDescription());
        RestClient<Product> productRestClient = new RestClient<>("http://PRODUCT/product/{id}"+order.getProductId());
        Product product = productRestClient.get(Product.class);
        orderResponseDto.setProduct(product);
        RestClient<Customer> customerRestClient = new RestClient<>("http://CUSTOMER/customer/{id}");
        Customer customer = customerRestClient.get(Customer.class);
        orderResponseDto.setCustomer(customer);
        return orderResponseDto;
    }
}

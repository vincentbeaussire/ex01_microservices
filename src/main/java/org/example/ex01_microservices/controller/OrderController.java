package org.example.ex01_microservices.controller;


import org.example.ex01_microservices.dto.OrderResponseDto;
import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Order;
import org.example.ex01_microservices.model.Product;
import org.example.ex01_microservices.service.OrderService;
import org.example.ex01_microservices.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final RestTemplate restTemplate;

        public OrderService orderService;

        public OrderController(RestTemplate restTemplate, OrderService orderService) {
            this.restTemplate = restTemplate;
            this.orderService = orderService;
        }

        @GetMapping("/{id}")
        public OrderResponseDto getOrder(@PathVariable int id){
            Order order = orderService.getOrderById(id);
            return orderService.orderToOrderResponseDto(order);
        }


    @GetMapping("/{id}")
    public Order getOrderId(@PathVariable int id){

        Order order = new Order();
        order.setId(id);
        order.setDescription("Pc portable");
        Order orderr = restTemplate.getForObject(
                "http://ORDER/order/{id}",
                Order.class,
                id
        );
        order.setOrder(order);
        return order;
    }
}

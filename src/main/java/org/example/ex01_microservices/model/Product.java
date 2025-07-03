package org.example.ex01_microservices.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private int id;
    private String name;
    private double price;

    public void setOrder(Order order) {

    }
}

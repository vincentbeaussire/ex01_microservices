package org.example.ex01_microservices.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@
        Builder
@Data
public class Order {

    private int id;
    private String description;
    private int customerId;
    private int productId;

    public void setOrder(Order order) {
    }
}

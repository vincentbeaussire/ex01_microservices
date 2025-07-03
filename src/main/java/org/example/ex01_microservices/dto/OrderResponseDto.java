package org.example.ex01_microservices.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ex01_microservices.model.Customer;
import org.example.ex01_microservices.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderResponseDto {

    private int id;
    private String description;
    private Customer customer;
    private Product product;
}

package org.example.ex01_microservices.model;

public class Order {

    private int id;
    private String description;
    private String customer;
    private String product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription(String newMacBookPro) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomer(String mrDupont) {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct(String computerApple) {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}

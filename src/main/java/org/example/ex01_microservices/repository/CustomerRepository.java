package org.example.ex01_microservices.repository;

import org.example.ex01_microservices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

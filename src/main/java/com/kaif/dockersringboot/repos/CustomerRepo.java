package com.kaif.dockersringboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaif.dockersringboot.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
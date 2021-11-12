package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer,String> {

}

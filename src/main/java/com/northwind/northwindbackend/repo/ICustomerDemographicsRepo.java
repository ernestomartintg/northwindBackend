package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.CustomerDemographic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDemographicsRepo extends JpaRepository<CustomerDemographic,String> {
}

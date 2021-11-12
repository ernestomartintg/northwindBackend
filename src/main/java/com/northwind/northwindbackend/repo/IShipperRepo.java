package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipperRepo extends JpaRepository<Shipper,Integer> {
}

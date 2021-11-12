package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepo extends JpaRepository<Supplier,Integer> {
}

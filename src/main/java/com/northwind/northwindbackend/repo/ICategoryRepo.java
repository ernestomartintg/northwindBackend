package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {

}

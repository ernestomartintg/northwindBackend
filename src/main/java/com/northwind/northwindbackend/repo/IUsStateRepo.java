package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.UsStates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsStateRepo extends JpaRepository<UsStates,Integer> {
}

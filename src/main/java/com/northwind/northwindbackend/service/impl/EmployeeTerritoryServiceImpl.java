package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.model.EmployeeTerritory;
import com.northwind.northwindbackend.model.Territory;
import com.northwind.northwindbackend.repo.IEmployeeTerritoryRepo;
import com.northwind.northwindbackend.service.IEmployeeTerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTerritoryServiceImpl implements IEmployeeTerritoryService {

    @Autowired
    private IEmployeeTerritoryRepo repo;

    @Override
    public List<Employee> listarEmployeesPorTerritory(String idTerritory) {
        return repo.listarEmployeesPorTerritorio(idTerritory);
    }

    @Override
    public List<Territory> listarTerritoriosPorEmployee(Integer idEmployee) {
        return repo.listarTerritoriosPorEmployee(idEmployee);
    }

    @Override
    public Integer registrarDTO(Integer idEmployee, String idTerritory) {
        return repo.registrar(idEmployee,idTerritory);
    }

    @Override
    public Integer eliminarDTO(Integer idEmployee, String idTerritory) {
        return repo.eliminarEmployeeTerritory(idEmployee,idTerritory);    }
}

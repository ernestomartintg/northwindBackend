package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.model.EmployeeTerritory;
import com.northwind.northwindbackend.model.Territory;

import java.util.List;

public interface IEmployeeTerritoryService {
    List<Employee> listarEmployeesPorTerritory(String idTerritory);
    List<Territory> listarTerritoriosPorEmployee(Integer idEmployee);
    Integer registrarDTO(Integer idEmployee,String idTerritory);
    Integer eliminarDTO(Integer idEmployee,String idTerritory);

}

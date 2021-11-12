package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.EmployeeTerritoryDTO;
import com.northwind.northwindbackend.dto.TerritoryDTO;
import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.model.EmployeeTerritory;
import com.northwind.northwindbackend.model.Territory;
import com.northwind.northwindbackend.service.IEmployeeService;
import com.northwind.northwindbackend.service.IEmployeeTerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeeTerritory")
public class EmployeeTerritoryController {

    @Autowired
    private IEmployeeTerritoryService service;

    @GetMapping("/territory/{idTerritory}")
    public ResponseEntity<List<Employee>> listarEmployeesPorTerritory(
            @PathVariable("idTerritory") String idTerritory){
        /*
        List<EmployeeTerritory> employeeTerritories=new ArrayList<>();

        employeeTerritories=service.listarEmployeesPorTerritory(idTerritory);
        employeeTerritories.forEach(employeeTerritory -> System.out.println(employeeTerritory));

         */
        return new ResponseEntity<>(service.listarEmployeesPorTerritory(idTerritory), HttpStatus.OK);
    }

    @GetMapping("/employee/{idEmployee}")
    public ResponseEntity<List<Territory>> listarTerritoriosPorEmployee
            (@PathVariable("idEmployee") Integer idEmployee){

        return new ResponseEntity<>(service.listarTerritoriosPorEmployee(idEmployee),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> registrarEmployeeTerritory(@RequestBody EmployeeTerritoryDTO dto){
        if (service.registrarDTO(dto.getEmployee_id(),dto.getTerritory_id())==1){
            return ResponseEntity.ok("Registrado");
        }else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping
    public ResponseEntity<String> eliminarEmployeeTerritory(@RequestBody EmployeeTerritoryDTO dto){
        System.out.println(dto);
        if (service.eliminarDTO(dto.getEmployee_id(),dto.getTerritory_id())==1){
            return ResponseEntity.ok("Eliminado");
        }else {
            return ResponseEntity.noContent().build();
        }
    }

}

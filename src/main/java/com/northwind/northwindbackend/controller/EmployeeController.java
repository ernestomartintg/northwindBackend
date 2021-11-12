package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.EmployeesDTO;
import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements BasicController<Employee,Integer>,CreateUpdateController<EmployeesDTO> {

    @Autowired
    private IEmployeeService service;

    @Override
    public ResponseEntity<List<Employee>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Employee>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> registrar(EmployeesDTO obj) {
        //System.out.println(obj);
        return ResponseEntity.ok(service.registrarDTO(obj));

    }

    @Override
    public ResponseEntity<Object> modificar(EmployeesDTO obj) {
        return ResponseEntity.ok(service.modificarDTO(obj));
    }
}

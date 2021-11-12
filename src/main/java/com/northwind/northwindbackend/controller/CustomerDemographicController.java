package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.CustomerDemographic;
import com.northwind.northwindbackend.repo.ICustomerDemographicsRepo;
import com.northwind.northwindbackend.service.ICustomerDemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customerdemographic")
public class CustomerDemographicController implements GenericController<CustomerDemographic,String> {

    @Autowired
    private ICustomerDemographicsService service;

    @Override
    public ResponseEntity<List<CustomerDemographic>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDemographic> listarPorId(String id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomerDemographic> registrar(CustomerDemographic obj) {
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDemographic> modificar(CustomerDemographic obj) {
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(String id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<CustomerDemographic>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }
}

package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.Customer;
import com.northwind.northwindbackend.service.ICustomerService;
import com.northwind.northwindbackend.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController implements GenericController<Customer,String> {

    @Autowired
    private ICustomerService service;

    @Override
    public ResponseEntity<List<Customer>> listar() {
        List<Customer> list=service.listar();
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> listarPorId(String id) {
        Customer customer=service.listarPorId(id);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> registrar(Customer obj) {
        Customer customer=service.registrar(obj);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Customer> modificar(Customer obj) {
        Customer customer=service.modificar(obj);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(String id) {
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Customer>> listarPageable(Pageable pageable) {
        Page<Customer> customers=service.listarPageable(pageable);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
}

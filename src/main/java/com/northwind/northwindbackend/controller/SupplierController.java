package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.Supplier;
import com.northwind.northwindbackend.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController implements GenericController<Supplier,Integer> {

    @Autowired
    private SupplierServiceImpl service;

    @Override
    public ResponseEntity<List<Supplier>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Supplier> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Supplier> registrar(Supplier obj) {
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Supplier> modificar(Supplier obj) {
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Supplier>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }
}

package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.Shipper;
import com.northwind.northwindbackend.service.impl.ShipperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/shippers")
public class ShipperController implements GenericController<Shipper,Integer> {

    @Autowired
    private ShipperServiceImpl service;

    @Override
    public ResponseEntity<List<Shipper>> listar() {
        List<Shipper> list=service.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Shipper> listarPorId(Integer id) {
        Shipper shipper=service.listarPorId(id);
        return new ResponseEntity<>(shipper,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Shipper> registrar(Shipper obj) {
        Shipper shipper=service.registrar(obj);
        return new ResponseEntity<>(shipper,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Shipper> modificar(Shipper obj) {
        Shipper shipper=service.modificar(obj);
        return new ResponseEntity<>(shipper,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Shipper>> listarPageable(Pageable pageable) {
        Page<Shipper> shippers=service.listarPageable(pageable);
        return new ResponseEntity<>(shippers,HttpStatus.OK);
    }
}

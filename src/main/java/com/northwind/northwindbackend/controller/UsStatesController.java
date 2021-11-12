package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.UsStates;
import com.northwind.northwindbackend.service.impl.UsStatesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usStates")
public class UsStatesController {

    @Autowired
    private UsStatesServiceImpl service;

    @GetMapping
    public ResponseEntity<List<UsStates>> listar(){
        List<UsStates> list=service.listar();
        return new ResponseEntity<List<UsStates>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsStates> listarPorId(@PathVariable("id") Integer id){
        UsStates obj=service.listarPorId(id);
        return new ResponseEntity<UsStates>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsStates> registrar(@RequestBody UsStates usStates){
        UsStates obj=service.registrar(usStates);
        return new ResponseEntity<UsStates>(obj,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UsStates> modificar(@RequestBody UsStates usStates){
        UsStates obj=service.modificar(usStates);
        return new ResponseEntity<UsStates>(obj,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarPorId(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<UsStates>> listarPageable(Pageable pageable){
        Page<UsStates> lista=service.listarPageable(pageable);
        return new ResponseEntity<Page<UsStates>>(lista,HttpStatus.OK);
    }

}

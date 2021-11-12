package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.UsStates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GenericController<T,V> {

    @GetMapping
    public ResponseEntity<List<T>> listar();
    @GetMapping("/{id}")
    public ResponseEntity<T> listarPorId(@PathVariable("id") V id);
    @PostMapping
    public ResponseEntity<T> registrar(@RequestBody T obj);
    @PutMapping
    public ResponseEntity<T> modificar(@RequestBody T obj);
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarPorId(@PathVariable("id") V id);
    @GetMapping("/pageable")
    public ResponseEntity<Page<T>> listarPageable(Pageable pageable);

}

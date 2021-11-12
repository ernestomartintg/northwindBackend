package com.northwind.northwindbackend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface BasicController<T,V> {
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> listar();
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<T> listarPorId(@PathVariable("id") V id);
    @DeleteMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminarPorId(@PathVariable("id") V id);
    @GetMapping(value = "/pageable",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<T>> listarPageable(Pageable pageable);
}

package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.model.Category;
import com.northwind.northwindbackend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController  implements GenericController<Category,Integer>  {

    @Autowired
    private ICategoryService service;

    @Override
    public ResponseEntity<List<Category>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> registrar(Category obj)  {
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.CREATED);
        //https://frontbackend.com/spring-boot/spring-boot-upload-file-to-postgresql-database
    }

    @Override
    public ResponseEntity<Category> modificar(Category obj) {
        return new ResponseEntity<>(service.modificar(obj),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Category>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }
}

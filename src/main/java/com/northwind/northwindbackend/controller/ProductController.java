package com.northwind.northwindbackend.controller;


import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.Product;
import com.northwind.northwindbackend.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController implements BasicController<Product,Integer>,CreateUpdateController<ProductDTO> {

    @Autowired
    private ProductServiceImpl service;

    @Override
    public ResponseEntity<List<Product>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Product>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> registrar(ProductDTO obj) {
        if (service.registrarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getProductId()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Object> modificar(ProductDTO obj) {
        if (service.modificarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getProductId()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}

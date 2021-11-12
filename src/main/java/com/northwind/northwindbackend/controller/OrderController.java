package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.OrderDTO;
import com.northwind.northwindbackend.model.Order;
import com.northwind.northwindbackend.service.IOrderService;
import com.northwind.northwindbackend.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController implements CreateUpdateController<OrderDTO>,BasicController<Order,Integer>{

    @Autowired
    private IOrderService service;

    @Override
    public ResponseEntity<List<Order>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Order>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> registrar(OrderDTO obj) {
        System.out.println(obj);
        if (service.registrarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getOrderId()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Object> modificar(OrderDTO obj) {
        if (service.modificarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getOrderId()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}

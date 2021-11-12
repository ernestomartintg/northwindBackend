package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.OrderDTO;
import com.northwind.northwindbackend.model.Order;
import com.northwind.northwindbackend.repo.IOrderRepo;
import com.northwind.northwindbackend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepo repo;



    @Override
    public List<Order> listar() {
        return repo.findAll();
    }

    @Override
    public Order listarPorId(Integer id) {
        return repo.findById(id).orElseGet(Order::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Order> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Integer registrarDTO(OrderDTO obj) {
        return repo.registrarOrder(obj.getOrderId(),obj.getCustomerId(),obj.getEmployeeId(),
                obj.getOrder_date(),obj.getRequired_date(),obj.getShipped_date(),
                obj.getShipVia(),obj.getFreight(),obj.getShip_name(),obj.getShip_address(),
                obj.getShip_city(),obj.getShip_region(),obj.getShip_postal_code(),
                obj.getShip_country());
    }

    @Override
    public Integer modificarDTO(OrderDTO obj) {
        return repo.modificarOrder(obj.getOrderId(),obj.getCustomerId(),obj.getEmployeeId(),
                obj.getOrder_date(),obj.getRequired_date(),obj.getShipped_date(),
                obj.getShipVia(),obj.getFreight(),obj.getShip_name(),obj.getShip_address(),
                obj.getShip_city(),obj.getShip_region(),obj.getShip_postal_code(),
                obj.getShip_country());
    }
}

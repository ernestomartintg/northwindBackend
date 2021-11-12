package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.OrderDetailsDTO;
import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.Order;
import com.northwind.northwindbackend.model.OrderDetail;
import com.northwind.northwindbackend.model.Product;
import com.northwind.northwindbackend.repo.IOrderDetailRepo;
import com.northwind.northwindbackend.service.IOrderDetailService;
import com.northwind.northwindbackend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepo repo;


    @Override
    public Integer registrarDTO(OrderDetailsDTO obj) {
        return repo.registrarOrderDetail(obj.getOrderId(),obj.getProductId(),
                obj.getUnit_price(),obj.getQuantity(),obj.getDiscount());
    }

    @Override
    public Integer modificarDTO(OrderDetailsDTO obj) {
        return null;
    }

    @Override
    public List<OrderDetail> listar() {
        return repo.findAll();
    }

    @Override
    public OrderDetail listarPorId(Integer id) {
        return repo.findById(id).orElseGet(OrderDetail::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }

    @Override
    public Page<OrderDetail> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Integer eliminarOrderDetail(Integer orderId, Integer productId) {
        return repo.eliminarOrderDetail(orderId,productId);
    }


    @Override
    public List<Product> productosInOrder(Integer idOrder) {
        List<Product> listaNull=new ArrayList<>();
        return repo.productosInOrder(idOrder);
    }

    @Override
    public Integer updateOrderDetail(OrderDetailsDTO dto) {
        return repo.updateOrderDetail(dto.getOrderId(),dto.getProductId()
                ,dto.getUnit_price(),dto.getQuantity(),dto.getDiscount());
    }

    @Override
    public OrderDetail selectByIdOrderAndIdProduct(Integer idOrder, Integer idProducto) {
        return repo.selectOrderDetail(idOrder,idProducto);
    }
}

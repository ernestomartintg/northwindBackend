package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.OrderDetailsDTO;
import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.OrderDetail;
import com.northwind.northwindbackend.model.Product;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService extends IREADDELETE<OrderDetail,Integer>
        ,ICREATEUPDATEDTO<OrderDetailsDTO> {

    Integer eliminarOrderDetail(Integer orderId,Integer productId);
    /*
    Integer registarOrderDetail(Integer orderId,Integer productId,
                                Float unitPrice,Integer quantity,Float discount);

     */
    List<Product> productosInOrder(Integer idOrder);
    Integer updateOrderDetail(OrderDetailsDTO dto);
    OrderDetail selectByIdOrderAndIdProduct(Integer idOrder,Integer idProducto);
}

package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.OrderDTO;
import com.northwind.northwindbackend.model.Order;

public interface IOrderService extends ICREATEUPDATEDTO<OrderDTO>, IREADDELETE<Order,Integer>{
}

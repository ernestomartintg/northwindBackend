package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.Product;

public interface IProductService extends ICREATEUPDATEDTO<ProductDTO>,IREADDELETE<Product,Integer> {
}

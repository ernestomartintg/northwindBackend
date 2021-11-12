package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.Product;
import com.northwind.northwindbackend.repo.IProductRepo;
import com.northwind.northwindbackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepo repo;

    @Override
    public List<Product> listar() {
        return repo.findAll();
    }

    @Override
    public Product listarPorId(Integer id) {
        return repo.findById(id).orElseGet(Product::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Product> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Integer registrarDTO(ProductDTO obj) {
        return repo.registrarProductoDTO(obj.getProductId(),obj.getProduct_name(),obj.getSupplierId(),
                obj.getCategoryId(),obj.getQuantity_per_unit(),obj.getUnit_price(),obj.getUnits_in_stock(),
                obj.getUnits_on_order(),obj.getReorder_level(),obj.getDiscontinued());
    }

    @Override
    public Integer modificarDTO(ProductDTO obj) {
        return repo.modificarProductoDTO(obj.getProductId(),obj.getProduct_name(),obj.getSupplierId(),
                obj.getCategoryId(),obj.getQuantity_per_unit(),obj.getUnit_price(),obj.getUnits_in_stock(),
                obj.getUnits_on_order(),obj.getReorder_level(),obj.getDiscontinued());
    }
}

package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.Shipper;
import com.northwind.northwindbackend.repo.IShipperRepo;
import com.northwind.northwindbackend.service.IShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperServiceImpl implements IShipperService {

    @Autowired
    private IShipperRepo repo;

    @Override
    public Shipper registrar(Shipper obj) {
        return repo.save(obj);
    }

    @Override
    public Shipper modificar(Shipper obj) {
        return repo.save(obj);
    }

    @Override
    public List<Shipper> listar() {
        return repo.findAll();
    }

    @Override
    public Shipper listarPorId(Integer id) {
        Optional<Shipper> shipper=repo.findById(id);
        return shipper.orElseGet(Shipper::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Shipper> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.CustomerDemographic;
import com.northwind.northwindbackend.repo.ICustomerDemographicsRepo;
import com.northwind.northwindbackend.service.ICustomerDemographicsService;
import com.northwind.northwindbackend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDemographicServiceImpl implements ICustomerDemographicsService {

    @Autowired
    private ICustomerDemographicsRepo repo;

    @Override
    public CustomerDemographic registrar(CustomerDemographic obj) {
        return repo.save(obj);
    }

    @Override
    public CustomerDemographic modificar(CustomerDemographic obj) {
        return repo.save(obj);
    }

    @Override
    public List<CustomerDemographic> listar() {
        return repo.findAll();
    }

    @Override
    public CustomerDemographic listarPorId(String id) {
        return repo.findById(id).orElseGet(CustomerDemographic::new);
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<CustomerDemographic> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

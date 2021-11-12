package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.Customer;
import com.northwind.northwindbackend.repo.ICustomerRepo;
import com.northwind.northwindbackend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepo repo;

    @Override
    public Customer registrar(Customer obj) {
        return repo.save(obj);
    }

    @Override
    public Customer modificar(Customer obj) {
        return repo.save(obj);
    }

    @Override
    public List<Customer> listar() {
        return repo.findAll();
    }

    @Override
    public Customer listarPorId(String id) {
        Optional<Customer> obj=repo.findById(id);

        return obj.orElseGet(Customer::new);
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Customer> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

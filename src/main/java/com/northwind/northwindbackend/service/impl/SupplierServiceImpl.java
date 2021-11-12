package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.Supplier;
import com.northwind.northwindbackend.repo.ISupplierRepo;
import com.northwind.northwindbackend.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierRepo repo;

    @Override
    public Supplier registrar(Supplier obj) {
        return repo.save(obj);
    }

    @Override
    public Supplier modificar(Supplier obj) {
        return repo.save(obj);
    }

    @Override
    public List<Supplier> listar() {
        return repo.findAll();
    }

    @Override
    public Supplier listarPorId(Integer id) {
        Optional<Supplier> supplier=repo.findById(id);
        return supplier.orElseGet(Supplier::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Supplier> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

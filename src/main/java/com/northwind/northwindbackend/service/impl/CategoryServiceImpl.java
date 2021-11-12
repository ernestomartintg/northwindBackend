package com.northwind.northwindbackend.service.impl;


import com.northwind.northwindbackend.model.Category;
import com.northwind.northwindbackend.repo.ICategoryRepo;
import com.northwind.northwindbackend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService  {

    @Autowired
    private ICategoryRepo repo;

    @Override
    public Category registrar(Category obj) {
        return repo.save(obj);
    }

    @Override
    public Category modificar(Category obj) {
        return repo.save(obj);
    }

    @Override
    public List<Category> listar() {
        return repo.findAll();
    }

    @Override
    public Category listarPorId(Integer id) {
        return repo.findById(id).orElseGet(Category::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Category> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

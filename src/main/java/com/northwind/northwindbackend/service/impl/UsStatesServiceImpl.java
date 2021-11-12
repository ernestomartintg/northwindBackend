package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.model.UsStates;
import com.northwind.northwindbackend.repo.IUsStateRepo;
import com.northwind.northwindbackend.service.IUsStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsStatesServiceImpl implements IUsStateService {

    @Autowired
    private IUsStateRepo repo;


    @Override
    public UsStates registrar(UsStates obj) {
        return repo.save(obj);
    }

    @Override
    public UsStates modificar(UsStates obj) {
        return repo.save(obj);
    }

    @Override
    public List<UsStates> listar() {
        return repo.findAll();
    }

    @Override
    public UsStates listarPorId(Integer id) {
        Optional<UsStates> usStates=repo.findById(id);
        return usStates.orElseGet(UsStates::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<UsStates> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }


}

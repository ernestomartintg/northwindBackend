package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.TerritoryDTO;
import com.northwind.northwindbackend.model.Territory;
import com.northwind.northwindbackend.repo.ITerritoryRepo;
import com.northwind.northwindbackend.service.ITerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerritoryServiceImpl implements ITerritoryService {

    @Autowired
    private ITerritoryRepo repo;


    @Override
    public List<Territory> listar() {
        return repo.findAll();
    }

    @Override
    public Territory listarPorId(String id) {
        return repo.findById(id).orElseGet(Territory::new);
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Territory> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }


    @Override
    public Integer registrarDTO(TerritoryDTO obj) {
        return repo.registrarDTO(obj.getTerritory_id(),obj.getTerritory_description()
                ,obj.getRegion_id());
    }

    @Override
    public Integer modificarDTO(TerritoryDTO obj) {
        return repo.modificarDTO(obj.getTerritory_id(),obj.getTerritory_description()
                ,obj.getRegion_id());
    }
}

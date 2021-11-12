package com.northwind.northwindbackend.service.impl;

import com.northwind.northwindbackend.dto.RegionDTO;
import com.northwind.northwindbackend.model.Region;
import com.northwind.northwindbackend.repo.IRegionRepo;
import com.northwind.northwindbackend.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements IRegionService{

    @Autowired
    private IRegionRepo repo;

    @Transactional
    @Override
    public Region registrar(Region obj) {
        //obj.getTerritories().forEach(territory -> {territory.setRegion(obj);});
        return repo.save(obj);
    }

    @Override
    public Region modificar(Region obj) {
        return repo.save(obj);
    }

    @Override
    public List<Region> listar() {
        return repo.findAll();
    }

    @Override
    public Region listarPorId(Integer id) {
        Optional<Region> region=repo.findById(id);
        return region.orElseGet(Region::new);
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Region> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Integer registrarRegionDTO(RegionDTO dto) {
        return repo.registrarDTO(dto.getRegion_id(),dto.getRegion_description());
    }
}

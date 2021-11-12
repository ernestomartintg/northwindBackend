package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.TerritoryDTO;
import com.northwind.northwindbackend.model.Territory;
import com.northwind.northwindbackend.service.impl.TerritoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/territories")
public class TerritoryController implements BasicController<Territory,String>,CreateUpdateController<TerritoryDTO> {

    @Autowired
    private TerritoryServiceImpl service;

    @Override
    public ResponseEntity<List<Territory>> listar() {
        return new ResponseEntity<>(service.listar(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Territory> listarPorId(String id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(String id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Territory>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> registrar(TerritoryDTO obj) {
        if (service.registrarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getTerritory_id()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Object> modificar(TerritoryDTO obj) {
        if (service.modificarDTO(obj)==1){
            return ResponseEntity.ok(service.listarPorId(obj.getTerritory_id()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}

package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.RegionDTO;
import com.northwind.northwindbackend.model.Region;
import com.northwind.northwindbackend.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController implements GenericController<Region,Integer> {

    @Autowired
    private RegionServiceImpl service;

    @Override
    public ResponseEntity<List<Region>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Region> listarPorId(Integer id) {
        return new ResponseEntity<>(service.listarPorId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Region> registrar(Region obj) {
        System.out.println(obj);
        //return null;
        return new ResponseEntity<>(service.registrar(obj),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Region> modificar(Region obj) {
        return new ResponseEntity<>(service.modificar(obj),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Page<Region>> listarPageable(Pageable pageable) {
        return new ResponseEntity<>(service.listarPageable(pageable),HttpStatus.OK);
    }

    @PostMapping("/dto")
    public ResponseEntity<String> registrarDTO(@RequestBody RegionDTO dto){
        System.out.println("Region DTO: "+dto);
        if(service.registrarRegionDTO(dto)==1){
            return new ResponseEntity<>("Ingresado con exito",HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("NO INGRESADO",HttpStatus.NO_CONTENT);
        }
    }
}

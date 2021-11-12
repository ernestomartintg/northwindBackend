package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.RegionDTO;
import com.northwind.northwindbackend.model.Region;

public interface IRegionService extends ICRUDBASIC<Region,Integer> {

    Integer registrarRegionDTO(RegionDTO dto);
}

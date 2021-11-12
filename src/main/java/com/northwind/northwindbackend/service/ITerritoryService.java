package com.northwind.northwindbackend.service;

import com.northwind.northwindbackend.dto.TerritoryDTO;
import com.northwind.northwindbackend.model.Territory;

public interface ITerritoryService extends ICREATEUPDATEDTO<TerritoryDTO>,IREADDELETE<Territory,String> {


}

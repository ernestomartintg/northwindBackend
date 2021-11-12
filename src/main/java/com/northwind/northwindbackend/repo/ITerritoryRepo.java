package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ITerritoryRepo extends JpaRepository<Territory,String> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO territories(territory_id,territory_description,region_id)" +
            " VALUES(:idTerr, :descripTerr, :idRegion)"
            ,nativeQuery = true)
    Integer registrarDTO(@Param("idTerr") String idTerritory, @Param("descripTerr") String descrip,
                         @Param("idRegion") Integer idRegion);

    @Transactional
    @Modifying
    @Query(value = "UPDATE territories SET territory_description=:descripTerr, region_id=:idRegion" +
            " WHERE territory_id=:idTerr",nativeQuery = true)
    Integer modificarDTO(@Param("idTerr") String idTerritory, @Param("descripTerr") String descrip,
                         @Param("idRegion") Integer idRegion);

}

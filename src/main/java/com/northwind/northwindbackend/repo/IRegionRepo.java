package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IRegionRepo extends JpaRepository<Region,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO region(region_id, region_description)" +
            " VALUES(:regionId, :regionDescrip)",nativeQuery = true)
    Integer registrarDTO(@Param("regionId") Integer regionId,
                         @Param("regionDescrip") String regionDescrip);

    @Transactional
    @Modifying
    @Query(value = "UPDATE region SET region_description=? WHERE region_id=:regionId",nativeQuery = true)
    Integer updateRegionDTO(@Param("regionId") Integer regionId,
                         @Param("regionDescrip") String regionDescrip);
}

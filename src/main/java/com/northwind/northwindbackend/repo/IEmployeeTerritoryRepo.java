package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Employee;
import com.northwind.northwindbackend.model.EmployeeTerritory;
import com.northwind.northwindbackend.model.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEmployeeTerritoryRepo extends JpaRepository<EmployeeTerritory,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO employee_territories(employee_id, territory_id) VALUES (:idEmployee, :idTerritory)",
            nativeQuery = true)
    Integer registrar(@Param("idEmployee") Integer idEmployee, @Param("idTerritory") String idTerritory);

    @Query("select et.employee from EmployeeTerritory et where et.territory.territory_id=:idTerritory")
    List<Employee> listarEmployeesPorTerritorio(@Param("idTerritory") String idTerritory);

    @Query("select et.territory from EmployeeTerritory et where et.employee.employee_id=:idEmployee")
    List<Territory> listarTerritoriosPorEmployee(@Param("idEmployee") Integer idTerritory);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM employee_territories WHERE employee_id=:idEmployee AND" +
            " territory_id=:idTerritory",nativeQuery = true)
    Integer eliminarEmployeeTerritory(@Param("idEmployee") Integer idEmployee,
                                      @Param("idTerritory") String idTerritory);
}

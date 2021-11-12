package com.northwind.northwindbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "employee_territories")
@IdClass(EmployeeTerritoryPK.class)
public class EmployeeTerritory {

    @Id
    private Employee employee;

    @Id
    private Territory territory;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }
}

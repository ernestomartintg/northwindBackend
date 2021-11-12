package com.northwind.northwindbackend.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeTerritoryPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "territory_id",nullable = false)
    private Territory territory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTerritoryPK that = (EmployeeTerritoryPK) o;
        return Objects.equals(employee, that.employee) && Objects.equals(territory, that.territory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, territory);
    }
}

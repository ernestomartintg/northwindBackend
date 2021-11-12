package com.northwind.northwindbackend.dto;

public class EmployeeTerritoryDTO {

    private Integer employee_id;
    private String territory_id;

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getTerritory_id() {
        return territory_id;
    }

    public void setTerritory_id(String territory_id) {
        this.territory_id = territory_id;
    }

    @Override
    public String toString() {
        return "EmployeeTerritoryDTO{" +
                "employee_id=" + employee_id +
                ", territory_id='" + territory_id + '\'' +
                '}';
    }
}

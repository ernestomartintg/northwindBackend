package com.northwind.northwindbackend.dto;

public class TerritoryDTO{

    private String territory_id;
    private String territory_description;
    private Integer region_id;

    public String getTerritory_id() {
        return territory_id;
    }

    public void setTerritory_id(String territory_id) {
        this.territory_id = territory_id;
    }

    public String getTerritory_description() {
        return territory_description;
    }

    public void setTerritory_description(String territory_description) {
        this.territory_description = territory_description;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    @Override
    public String toString() {
        return "TerritoryDTO{" +
                "territory_id='" + territory_id + '\'' +
                ", territory_description='" + territory_description + '\'' +
                ", region_id=" + region_id +
                '}';
    }
}

package com.northwind.northwindbackend.dto;

public class RegionDTO {

    private Integer region_id;
    private String region_description;

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getRegion_description() {
        return region_description;
    }

    public void setRegion_description(String region_description) {
        this.region_description = region_description;
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
                "region_id=" + region_id +
                ", region_description='" + region_description + '\'' +
                '}';
    }
}

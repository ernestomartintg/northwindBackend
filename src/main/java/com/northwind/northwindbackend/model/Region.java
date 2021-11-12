package com.northwind.northwindbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "region_id")
    private Integer region_id;

    private String region_description;
    @JsonIgnore
    @OneToMany(mappedBy = "region",cascade = {CascadeType.ALL}, orphanRemoval = true)
    List<Territory> territories;

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

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }

    @Override
    public String toString() {
        return "Region{" +
                "region_id=" + region_id +
                ", region_description='" + region_description + '\'' +
                ", territories=" + territories +
                '}';
    }
}

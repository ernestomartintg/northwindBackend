package com.northwind.northwindbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "territories")
public class Territory {

    @Id
    @Column(length = 20)
    private String territory_id;

    private String territory_description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "region_id",nullable = false,
    foreignKey = @ForeignKey(name = "fk_territories_region"),
    insertable = false,updatable = false)
    private Region region;

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

    public Region getRegion() {
        return region   ;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Territory{" +
                "territory_id='" + territory_id + '\'' +
                ", territory_description='" + territory_description + '\'' +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Territory territory = (Territory) o;
        return Objects.equals(territory_id, territory.territory_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(territory_id);
    }
}
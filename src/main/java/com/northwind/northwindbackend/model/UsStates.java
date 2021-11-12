package com.northwind.northwindbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "us_states")
public class UsStates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "state_name", nullable = false, length = 100)
    private String stateName;

    @Column(name="state_abbr",length = 2)
    private String stateAbbr;

    @Column(name = "state_region",length = 50)
    private String stateRegion;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    @Override
    public String toString() {
        return "UsStates{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", stateRegion='" + stateRegion + '\'' +
                '}';
    }
}

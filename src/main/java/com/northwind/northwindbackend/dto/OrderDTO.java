package com.northwind.northwindbackend.dto;

import java.time.LocalDateTime;

public class OrderDTO {
    private Integer orderId;
    private String customerId;
    private Integer employeeId;
    private Integer shipVia;
    private LocalDateTime order_date;
    private LocalDateTime required_date;
    private LocalDateTime shipped_date;
    private Float freight;
    private String ship_name;
    private String ship_address;
    private String ship_city;
    private String ship_region;
    private String ship_postal_code;
    private String ship_country;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public LocalDateTime getRequired_date() {
        return required_date;
    }

    public void setRequired_date(LocalDateTime required_date) {
        this.required_date = required_date;
    }

    public LocalDateTime getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(LocalDateTime shipped_date) {
        this.shipped_date = shipped_date;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getShip_address() {
        return ship_address;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public String getShip_city() {
        return ship_city;
    }

    public void setShip_city(String ship_city) {
        this.ship_city = ship_city;
    }

    public String getShip_region() {
        return ship_region;
    }

    public void setShip_region(String ship_region) {
        this.ship_region = ship_region;
    }

    public String getShip_postal_code() {
        return ship_postal_code;
    }

    public void setShip_postal_code(String ship_postal_code) {
        this.ship_postal_code = ship_postal_code;
    }

    public String getShip_country() {
        return ship_country;
    }

    public void setShip_country(String ship_country) {
        this.ship_country = ship_country;
    }

    public Integer getShipVia() {
        return shipVia;
    }

    public void setShipVia(Integer shipVia) {
        this.shipVia = shipVia;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", shipVia=" + shipVia +
                ", order_date=" + order_date +
                ", required_date=" + required_date +
                ", shipped_date=" + shipped_date +
                ", freight=" + freight +
                ", ship_name='" + ship_name + '\'' +
                ", ship_address='" + ship_address + '\'' +
                ", ship_city='" + ship_city + '\'' +
                ", ship_region='" + ship_region + '\'' +
                ", ship_postal_code='" + ship_postal_code + '\'' +
                ", ship_country='" + ship_country + '\'' +
                '}';
    }
}

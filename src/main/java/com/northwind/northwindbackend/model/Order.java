package com.northwind.northwindbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer order_id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,
                foreignKey = @ForeignKey(name = "fk_orders_employees"),
                insertable = false,updatable = false)
    @JsonBackReference
    private Employee employee;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_orders_customers"),
            insertable = false,updatable = false)
    @JsonBackReference
    private Customer customer;
    private LocalDateTime order_date;
    private LocalDateTime required_date;
    private LocalDateTime shipped_date;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ship_via",nullable = false,
            foreignKey = @ForeignKey(name = "fk_orders_shippers"),
            insertable = false,updatable = false)
    @JsonBackReference
    private Shipper ship_via;
    private Float freight;
    @Column(length = 40)
    private String ship_name;
    @Column(length = 60)
    private String ship_address;
    @Column(length = 15)
    private String ship_city;
    @Column(length = 15)
    private String ship_region;
    @Column(length = 10)
    private String ship_postal_code;
    @Column(length = 15)
    private String ship_country;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Shipper getShip_via() {
        return ship_via;
    }

    public void setShip_via(Shipper ship_via) {
        this.ship_via = ship_via;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(order_id, order.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", employee=" + employee +
                ", customer=" + customer +
                ", order_date=" + order_date +
                ", required_date=" + required_date +
                ", shipped_date=" + shipped_date +
                ", ship_via=" + ship_via +
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

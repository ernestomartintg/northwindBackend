package com.northwind.northwindbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
@IdClass(OrderDetailPK.class)
public class OrderDetail {

    @Id
    private Order order;
    @Id
    private Product product;
    private Float unit_price;
    private Integer quantity;
    private Float discount;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unity_price) {
        this.unit_price = unity_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}

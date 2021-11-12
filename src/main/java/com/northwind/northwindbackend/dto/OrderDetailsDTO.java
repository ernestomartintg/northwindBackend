package com.northwind.northwindbackend.dto;

public class OrderDetailsDTO {
    private Integer orderId;
    private Integer productId;
    private Float unit_price;
    private Integer quantity;
    private Float discount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
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
        return "OrderDetailsDTO{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}

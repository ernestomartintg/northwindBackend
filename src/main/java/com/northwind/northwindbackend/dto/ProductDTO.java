package com.northwind.northwindbackend.dto;

public class ProductDTO  {

    private Integer productId;
    private String product_name;
    private Integer supplierId;
    private Integer categoryId;
    private String quantity_per_unit;
    private Float unit_price;
    private Integer units_in_stock;
    private Integer units_on_order;
    private Integer reorder_level;
    private Integer discontinued;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuantity_per_unit() {
        return quantity_per_unit;
    }

    public void setQuantity_per_unit(String quantity_per_unit) {
        this.quantity_per_unit = quantity_per_unit;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getUnits_in_stock() {
        return units_in_stock;
    }

    public void setUnits_in_stock(Integer units_in_stock) {
        this.units_in_stock = units_in_stock;
    }

    public Integer getUnits_on_order() {
        return units_on_order;
    }

    public void setUnits_on_order(Integer units_on_order) {
        this.units_on_order = units_on_order;
    }

    public Integer getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(Integer reorder_level) {
        this.reorder_level = reorder_level;
    }

    public Integer getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Integer discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", product_name='" + product_name + '\'' +
                ", supplierId=" + supplierId +
                ", categoryId=" + categoryId +
                ", quantity_per_unit='" + quantity_per_unit + '\'' +
                ", unit_price=" + unit_price +
                ", units_in_stock=" + units_in_stock +
                ", units_on_order=" + units_on_order +
                ", reorder_level=" + reorder_level +
                ", discontinued=" + discontinued +
                '}';
    }
}

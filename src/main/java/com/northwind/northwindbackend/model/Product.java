package com.northwind.northwindbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer product_id;
    @Column(length = 40)
    private String product_name;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supplier_id",nullable = false,
    foreignKey = @ForeignKey(name = "fk_products_suppliers"),
    insertable = false,updatable = false)
    @JsonBackReference
    private Supplier supplier;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_products_categories"),
            insertable = false,updatable = false)
    @JsonBackReference
    private Category category;
    @Column(length = 20)
    private String quantity_per_unit;
    private float unit_price;
    private Integer units_in_stock;
    private Integer units_on_order;
    private Integer reorder_level;
    private Integer discontinued;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", supplier=" + supplier.getCompany_name() +
                ", category=" + category.getCategory_name() +
                ", quantity_per_unit='" + quantity_per_unit + '\'' +
                ", unit_price=" + unit_price +
                ", units_in_stock=" + units_in_stock +
                ", units_on_order=" + units_on_order +
                ", reorder_level=" + reorder_level +
                ", discontinued=" + discontinued +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id);
    }
}

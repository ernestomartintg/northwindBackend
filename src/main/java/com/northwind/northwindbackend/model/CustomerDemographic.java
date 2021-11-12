package com.northwind.northwindbackend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_demographics")
public class CustomerDemographic {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String customer_type_id;
    private String customer_desc;

    public String getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(String customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_desc() {
        return customer_desc;
    }

    public void setCustomer_desc(String customer_desc) {
        this.customer_desc = customer_desc;
    }
}

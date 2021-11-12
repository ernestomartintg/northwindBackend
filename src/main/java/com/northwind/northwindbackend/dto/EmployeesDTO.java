package com.northwind.northwindbackend.dto;

import java.time.LocalDateTime;
import java.util.Arrays;

public class EmployeesDTO {
    private Integer employee_id;
    private String last_name;
    private String first_name;
    private String title;
    private String title_of_courtesy;
    private LocalDateTime birth_date;
    private LocalDateTime hire_date;
    private String address;
    private String city;
    private String region;
    private String postal_code;
    private String country;
    private String home_phone;
    private String extension;
    private byte[] photo;
    private String notes;
    private Integer reportsTo;
    private String photo_path;

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_of_courtesy() {
        return title_of_courtesy;
    }

    public void setTitle_of_courtesy(String title_of_courtesy) {
        this.title_of_courtesy = title_of_courtesy;
    }

    public LocalDateTime getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDateTime birth_date) {
        this.birth_date = birth_date;
    }

    public LocalDateTime getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDateTime hire_date) {
        this.hire_date = hire_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    @Override
    public String toString() {
        return "EmployeesDTO{" +
                "employee_id=" + employee_id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", title='" + title + '\'' +
                ", title_of_courtesy='" + title_of_courtesy + '\'' +
                ", birth_date=" + birth_date +
                ", hire_date=" + hire_date +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", extension='" + extension + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", notes='" + notes + '\'' +
                ", reportsTo=" + reportsTo +
                ", photo_path='" + photo_path + '\'' +
                '}';
    }
}

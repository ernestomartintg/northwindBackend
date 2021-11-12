package com.northwind.northwindbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Integer employee_id;
    @Column(length = 20)
    private String last_name;
    @Column(length = 10)
    private String first_name;
    @Column(length = 30)
    private String title;
    @Column(length = 25)
    private String title_of_courtesy;
    private LocalDateTime birth_date;
    private LocalDateTime hire_date;
    @Column(length = 60)
    private String address;
    @Column(length = 15)
    private String city;
    @Column(length = 15)
    private String region;
    @Column(length = 10)
    private String postal_code;
    @Column(length = 15)
    private String country;
    @Column(length = 24)
    private String home_phone;
    @Column(length = 4)
    private String extension;
    private byte[] photo;
    private String notes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reports_to")
    @JsonBackReference
    private Employee reports_to;
    @OneToMany(mappedBy = "reports_to")
    @JsonManagedReference
    private List<Employee> reportedEmployees;
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

    public Employee getReports_to() {
        return reports_to;
    }

    public void setReports_to(Employee reports_to) {
        this.reports_to = reports_to;
    }

    public List<Employee> getReportedEmployees() {
        return reportedEmployees;
    }

    public void setReportedEmployees(List<Employee> reportedEmployees) {
        this.reportedEmployees = reportedEmployees;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_id, employee.employee_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id);
    }

    @Override
    public String toString() {
        return "Employee{" +
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
                ", reports_to=" + reports_to +
                ", reportedEmployees=" + reportedEmployees +
                ", photo_path='" + photo_path + '\'' +
                '}';
    }
}

package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {

    @Transactional
    @Modifying
    @Query(value =
            "INSERT INTO employees(employee_id, last_name, first_name, title, title_of_courtesy, birth_date," +
            " hire_date, address, city, region, postal_code, country, home_phone," +
            " extension, photo, notes, reports_to, photo_path)" +
            " VALUES (:id, :lastname, :firstname, :title, :titleOfCourtesy, :birthDate, :hireDate, :address," +
            " :city, :region, :postalCode, :country, :homePhone, :extension, :photo, :notes, :reportsTo," +
            " :photoPath)",nativeQuery = true)
    Integer registrarDTO(@Param("id") Integer id,@Param("lastname") String lastname,
                         @Param("firstname") String firstname,@Param("title") String title,
                         @Param("titleOfCourtesy") String titleOfCourtesy,@Param("birthDate") LocalDateTime birthDate,
                         @Param("hireDate") LocalDateTime hireDate,@Param("address") String address,
                         @Param("city") String city,@Param("region") String region,
                         @Param("postalCode") String postalCode,@Param("country") String country,
                         @Param("homePhone") String homePhone,@Param("extension") String extension,
                         @Param("photo") byte[] photo,@Param("notes") String notes,
                         @Param("reportsTo") Integer reportsTo ,@Param("photoPath") String photoPath);

    @Transactional
    @Modifying
    @Query(value = "UPDATE employees SET last_name=:lastname, first_name=:firstname," +
            " title=:title, title_of_courtesy=:titleOfCourtesy, birth_date=:birthDate," +
            " hire_date=:hireDate, address=:address," +
            " city=:city, region=:region, postal_code=:postalCode," +
            " country=:country, home_phone=:homePhone, extension=:extension," +
            " photo=:photo, notes=:notes, reports_to=:reportsTo, photo_path=:photoPath" +
            " WHERE employee_id=:id",nativeQuery = true)
    Integer updateDTO(@Param("id") Integer id,@Param("lastname") String lastname,
                      @Param("firstname") String firstname,@Param("title") String title,
                      @Param("titleOfCourtesy") String titleOfCourtesy,@Param("birthDate") LocalDateTime birthDate,
                      @Param("hireDate") LocalDateTime hireDate,@Param("address") String address,
                      @Param("city") String city,@Param("region") String region,
                      @Param("postalCode") String postalCode,@Param("country") String country,
                      @Param("homePhone") String homePhone,@Param("extension") String extension,
                      @Param("photo") byte[] photo,@Param("notes") String notes,
                      @Param("reportsTo") Integer reportsTo ,@Param("photoPath") String photoPath);
}

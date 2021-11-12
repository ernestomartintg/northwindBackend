package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IOrderRepo extends JpaRepository<Order,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO orders(order_id, customer_id, employee_id," +
            " order_date, required_date, shipped_date," +
            " ship_via, freight, ship_name," +
            " ship_address, ship_city, ship_region," +
            " ship_postal_code, ship_country)" +
            " VALUES (:orderId, :customerId, :employeeId," +
            " :orderDate, :requiredDate, :shippedDate," +
            " :shipVia, :freight, :shipName, :shipAddress, :shipCity," +
            " :shipRegion, :shipPostalCode, :shipCountry)",nativeQuery = true)
    Integer registrarOrder(@Param("orderId") Integer id, @Param("customerId") String customerId,
                           @Param("employeeId") Integer employeeId, @Param("orderDate")LocalDateTime orderDate,
                           @Param("requiredDate") LocalDateTime requireDate,
                           @Param("shippedDate") LocalDateTime shippedDate,
                           @Param("shipVia") Integer shipVia, @Param("freight") Float freight,
                           @Param("shipName") String shipName, @Param("shipAddress") String shipAddress,
                           @Param("shipCity") String shipCity, @Param("shipRegion") String shipRegion,
                           @Param("shipPostalCode") String shipPostalCode, @Param("shipCountry") String shipCountry);

    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET customer_id=:customerId, employee_id=:employeeId," +
            " order_date=:orderDate, required_date=:requiredDate, shipped_date=:shippedDate, ship_via=:shipVia," +
            " freight=:freight, ship_name=:shipName, ship_address=:shipAddress, ship_city=:shipCity," +
            " ship_region=:shipRegion, ship_postal_code=:shipPostalCode, ship_country=:shipCountry" +
            " WHERE order_id=:orderId",nativeQuery = true)
    Integer modificarOrder(@Param("orderId") Integer id, @Param("customerId") String customerId,
                           @Param("employeeId") Integer employeeId, @Param("orderDate")LocalDateTime orderDate,
                           @Param("requiredDate") LocalDateTime requireDate,
                           @Param("shippedDate") LocalDateTime shippedDate,
                           @Param("shipVia") Integer shipVia, @Param("freight") Float freight,
                           @Param("shipName") String shipName, @Param("shipAddress") String shipAddress,
                           @Param("shipCity") String shipCity, @Param("shipRegion") String shipRegion,
                           @Param("shipPostalCode") String shipPostalCode, @Param("shipCountry") String shipCountry);

}

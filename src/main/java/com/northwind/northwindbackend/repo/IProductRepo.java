package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IProductRepo extends JpaRepository<Product,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO public.products(product_id, product_name," +
            " supplier_id, category_id, quantity_per_unit, unit_price," +
            " units_in_stock, units_on_order, reorder_level, discontinued)" +
            " VALUES (:productId, :productName, :supplierId, :categoryId, :quantityPerUnit," +
            " :unitPrice, :unitsInStock, :unitsOnOrder, :reorderLevel, :discontinued);",nativeQuery = true)
    Integer registrarProductoDTO(@Param("productId") Integer productId,@Param("productName") String productName,
                                 @Param("supplierId") Integer supplierId,@Param("categoryId") Integer categoryId,
                                 @Param("quantityPerUnit") String quantityPerUnit,@Param("unitPrice") Float unitPrice,
                                 @Param("unitsInStock") Integer unitsInStock,@Param("unitsOnOrder") Integer unitsOnOrder,
                                 @Param("reorderLevel") Integer reorderLevel,@Param("discontinued") Integer discontinued);

    @Transactional
    @Modifying
    @Query(value = "UPDATE products SET product_name=:productName, supplier_id=:supplierId," +
            " category_id=:categoryId, quantity_per_unit=:quantityPerUnit, unit_price=:unitPrice," +
            " units_in_stock=:unitsInStock, units_on_order=:unitsOnOrder, reorder_level=:reorderLevel," +
            " discontinued=:discontinued WHERE product_id=:productId",nativeQuery = true)
    Integer modificarProductoDTO(@Param("productId") Integer productId,@Param("productName") String productName,
                                 @Param("supplierId") Integer supplierId,@Param("categoryId") Integer categoryId,
                                 @Param("quantityPerUnit") String quantityPerUnit,@Param("unitPrice") Float unitPrice,
                                 @Param("unitsInStock") Integer unitsInStock,@Param("unitsOnOrder") Integer unitsOnOrder,
                                 @Param("reorderLevel") Integer reorderLevel,@Param("discontinued") Integer discontinued);
}

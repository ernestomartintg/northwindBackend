package com.northwind.northwindbackend.repo;

import com.northwind.northwindbackend.dto.ProductDTO;
import com.northwind.northwindbackend.model.OrderDetail;
import com.northwind.northwindbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IOrderDetailRepo extends JpaRepository<OrderDetail,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_details(order_id, product_id, unit_price, quantity, discount)" +
            " VALUES (:orderId, :productId, :unitPrice, :quantity, :discount)",nativeQuery = true)
    Integer registrarOrderDetail(@Param("orderId") Integer orderId,@Param("productId") Integer productId,
                                 @Param("unitPrice") Float unitPrice,@Param("quantity") Integer quantity,
                                 @Param("discount") Float discount);

    @Transactional
    @Modifying
    @Query(value = "UPDATE order_details SET unit_price=:unitPrice, quantity=:quantity, discount=:discount" +
            " WHERE order_id=:orderId AND product_id=:productId",nativeQuery = true)
    Integer updateOrderDetail(@Param("orderId") Integer orderId,@Param("productId") Integer productId,
                                 @Param("unitPrice") Float unitPrice,@Param("quantity") Integer quantity,
                                 @Param("discount") Float discount);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM order_details WHERE order_id=:orderId" +
            " AND product_id=:productId",nativeQuery = true)
    Integer eliminarOrderDetail(@Param("orderId") Integer orderId,
                                @Param("productId") Integer productID);


    @Query(value = "SELECT ord.product FROM OrderDetail ord WHERE ord.order.order_id=:idOrder")
    List<Product> productosInOrder(@Param("idOrder") Integer idOrder);

    @Query(value = "FROM OrderDetail WHERE order.order_id=:idOrder AND product.product_id=:idProducto")
    OrderDetail selectOrderDetail(@Param("idOrder")Integer idOrder,@Param("idProducto")Integer idProducto);
}

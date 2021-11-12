package com.northwind.northwindbackend.controller;

import com.northwind.northwindbackend.dto.OrderDetailsDTO;
import com.northwind.northwindbackend.model.OrderDetail;
import com.northwind.northwindbackend.model.Product;
import com.northwind.northwindbackend.repo.IOrderDetailRepo;
import com.northwind.northwindbackend.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController implements CreateUpdateController<OrderDetailsDTO>
        ,BasicController<OrderDetail,Integer> {

    @Autowired
    private IOrderDetailService service;

    @Override
    public ResponseEntity<List<OrderDetail>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<Product>> listarProductosPorOrder(@PathVariable("id") Integer orderId){
        System.out.println(orderId);;
        System.out.println(service.productosInOrder(orderId));
        return ResponseEntity.ok(service.productosInOrder(orderId));
    }

    @Override
    public ResponseEntity<OrderDetail> listarPorId(Integer id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @GetMapping(value = "/{idOrder}/{idProducto}")
    public ResponseEntity<OrderDetail> listarPorOrderIdProductId(@PathVariable("idOrder")Integer idOrder,
                                                                 @PathVariable("idProducto")Integer idProducto){
        return ResponseEntity.ok(service.selectByIdOrderAndIdProduct(idOrder,idProducto));
    }

    @Override
    public ResponseEntity<Object> eliminarPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<OrderDetail>> listarPageable(Pageable pageable) {
        return ResponseEntity.ok(service.listarPageable(pageable));
    }

    @Override
    public ResponseEntity<Object> registrar(OrderDetailsDTO obj) {
        System.out.println(obj);
        if(service.registrarDTO(obj)==1){
            return ResponseEntity.ok(obj);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<Object> modificar(OrderDetailsDTO obj) {
        if(service.updateOrderDetail(obj)==1){
            return ResponseEntity.ok(service.selectByIdOrderAndIdProduct(obj.getOrderId(),obj.getProductId()));
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(value = "/{idOrder}/{idProducto}")
    public ResponseEntity<String> eliminarOrderProducto(@PathVariable("idOrder")Integer idOrder,
                                                        @PathVariable("idProducto")Integer idProducto){
        System.out.println(idOrder.toString());
        System.out.println(idProducto.toString());
        if(service.eliminarOrderDetail(idOrder,idProducto)==1){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.internalServerError().body("ERROR, no se elimino");
        }
    }
}

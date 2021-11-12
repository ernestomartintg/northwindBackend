package com.northwind.northwindbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICRUDBASIC<T,V> {
    T registrar(T obj);
    T modificar(T obj);
    List<T> listar();
    T listarPorId(V id);
    boolean eliminar(V id);
    Page<T> listarPageable(Pageable pageable);
}

package com.northwind.northwindbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IREADDELETE<T,V> {

    List<T> listar();
    T listarPorId(V id);
    boolean eliminar(V id);
    Page<T> listarPageable(Pageable pageable);
}

package com.northwind.northwindbackend.service;

public interface ICREATEUPDATEDTO<T> {
    Integer registrarDTO(T obj);
    Integer modificarDTO(T obj);
}

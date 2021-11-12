package com.northwind.northwindbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ExceptionResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime fecha;
    private String mensaje;
    private List<String> detalles;

    public ExceptionResponse() {
        super();
        this.fecha= LocalDateTime.now();
    }

    public ExceptionResponse(final HttpStatus status,final String mensaje,final List<String> detalles) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public ExceptionResponse(final HttpStatus status,final String mensaje,final String error) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        detalles= Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(final String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(final List<String> detalles) {
        this.detalles = detalles;
    }

    public void setDetalle(final String detalle){
        detalles= Arrays.asList(detalle);
    }
}

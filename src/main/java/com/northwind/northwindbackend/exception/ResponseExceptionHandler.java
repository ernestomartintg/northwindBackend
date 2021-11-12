package com.northwind.northwindbackend.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    //Error 400

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        final List<String> errors=new ArrayList<>();
        ex.getBindingResult().getFieldErrors().stream()
                .forEach(fieldError -> errors.add(fieldError.getField()+":"+fieldError.getDefaultMessage()));
        ex.getBindingResult().getGlobalErrors().stream().forEach(
                objectError -> errors.add(objectError.getObjectName()+":"+objectError.getDefaultMessage()));
        final ExceptionResponse exceptionResponse=new ExceptionResponse(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage()
                ,errors);
        return handleExceptionInternal(ex,exceptionResponse,headers,exceptionResponse.getStatus(),request);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex
            , final WebRequest request){
        logger.info(ex.getClass().getName());
        final String error=ex.getName()+" should be of type "+ex.getRequiredType().getName();
        final ExceptionResponse exceptionResponse=new ExceptionResponse(HttpStatus.BAD_REQUEST
                ,ex.getLocalizedMessage(),error);
        return new ResponseEntity<Object>(exceptionResponse,new HttpHeaders(),exceptionResponse.getStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex
            ,final WebRequest request){
        logger.info(ex.getClass().getName());
        final List<String> errors=new ArrayList<>();
        ex.getConstraintViolations().stream().forEach(
                constraintViolation -> errors.add(constraintViolation.getRootBeanClass().getName()+" "
                        +constraintViolation.getPropertyPath()+": "+constraintViolation.getMessage()));
        final ExceptionResponse exceptionResponse=new ExceptionResponse(HttpStatus.BAD_REQUEST
                ,ex.getLocalizedMessage(),errors);
        return new ResponseEntity<>(exceptionResponse,new HttpHeaders(),exceptionResponse.getStatus());
    }

    //https://www.tabnine.com/code/java/classes/org.springframework.http.converter.HttpMessageNotReadableException
    public ResponseEntity<Object> messageNotReadableException(
            HttpMessageNotReadableException exception,
            final WebRequest request){
        return null;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex,final WebRequest request){
        logger.info(ex.getClass().getName());
        logger.error("error",ex);
        final ExceptionResponse exceptionResponse=new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),"Error occurred");
        return new ResponseEntity<Object>(exceptionResponse,new HttpHeaders(),exceptionResponse.getStatus());
    }
}

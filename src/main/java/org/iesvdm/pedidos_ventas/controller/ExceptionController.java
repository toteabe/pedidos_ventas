package org.iesvdm.pedidos_ventas.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String manejarException(Exception exception) {

        log.info(exception.getMessage());

        return "error";
    }

}

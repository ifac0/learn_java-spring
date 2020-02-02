package com.stdy.springwebmvc.rest;

import com.stdy.springwebmvc.exception.JediNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RespirceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JediNotFoundException.class)
    public void notFound () {

    }
}

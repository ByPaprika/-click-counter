package com.task.demo.controllers;

import com.task.demo.exceptions.ActionWasBlockedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler({ActionWasBlockedException.class})
    public String handleActionWasBlockedException() {
        return "";
    }
}

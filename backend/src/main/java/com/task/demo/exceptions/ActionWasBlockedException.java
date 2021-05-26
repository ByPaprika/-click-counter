package com.task.demo.exceptions;

public class ActionWasBlockedException extends RuntimeException {

    public ActionWasBlockedException(String message) {
        super(message);
    }
}

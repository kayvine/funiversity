package com.switchfully.rest.funiversity.webapi.exceptionclasses;

public class CourseAlreadyExistsException extends RuntimeException {

    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}

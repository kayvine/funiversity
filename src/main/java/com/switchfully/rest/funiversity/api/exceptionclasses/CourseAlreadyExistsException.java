package com.switchfully.rest.funiversity.api.exceptionclasses;

public class CourseAlreadyExistsException extends RuntimeException {

    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}

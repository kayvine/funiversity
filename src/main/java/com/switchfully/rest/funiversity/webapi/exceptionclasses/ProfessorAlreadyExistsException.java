package com.switchfully.rest.funiversity.webapi.exceptionclasses;

public class ProfessorAlreadyExistsException extends RuntimeException {

    public ProfessorAlreadyExistsException(String message) {
        super(message);
    }

}

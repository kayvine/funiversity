package com.switchfully.rest.funiversity.api.exceptionclasses;

public class ProfessorAlreadyExistsException extends RuntimeException {

    public ProfessorAlreadyExistsException(String message) {
        super(message);
    }

}

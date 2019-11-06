package com.switchfully.rest.funiversity.api;

import com.switchfully.rest.funiversity.api.exceptionclasses.CourseAlreadyExistsException;
import com.switchfully.rest.funiversity.api.exceptionclasses.ProfessorAlreadyExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfessorAlreadyExistsException.class)
    protected void professorExistsException(ProfessorAlreadyExistsException e, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(CourseAlreadyExistsException.class)
    protected void professorExistsException(CourseAlreadyExistsException e, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), e.getMessage());
    }

    // other @ExceptionHandler annotated methods handling different exceptions in different ways.

}

package com.switchfully.rest.funiversity.webapi.dtos;

public class RequestProfessorDto {

    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public RequestProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public RequestProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

}

package com.switchfully.rest.funiversity.api.dtos;

import java.util.Objects;

public class ResponseProfessorDto {

    private String id;
    private String firstname;
    private String lastname;

    public String getId() {
        return id;
    }

    public ResponseProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ResponseProfessorDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ResponseProfessorDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseProfessorDto{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseProfessorDto that = (ResponseProfessorDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}
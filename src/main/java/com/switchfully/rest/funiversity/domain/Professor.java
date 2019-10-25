package com.switchfully.rest.funiversity.domain;

import com.switchfully.rest.funiversity.webapi.dtos.RequestProfessorDto;

import java.util.Objects;
import java.util.UUID;

public class Professor {

    private final String id;
    private String firstname;
    private String lastname;

    public Professor(String firstname, String lastname) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void update(RequestProfessorDto updateProfessorDto) {
        this.firstname = updateProfessorDto.getFirstname();
        this.lastname = updateProfessorDto.getLastname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(firstname, professor.firstname) &&
                Objects.equals(lastname, professor.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

}

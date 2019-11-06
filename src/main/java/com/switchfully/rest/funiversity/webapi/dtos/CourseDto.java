package com.switchfully.rest.funiversity.webapi.dtos;

public class CourseDto {

    private String id;
    private String name;
    private int studypoints;
    private String professorId;

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public CourseDto setStudypoints(int studypoints) {
        this.studypoints = studypoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public CourseDto setProfessorId(String professorId) {
        this.professorId = professorId;
        return this;
    }

}

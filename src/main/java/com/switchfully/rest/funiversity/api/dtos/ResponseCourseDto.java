package com.switchfully.rest.funiversity.api.dtos;

public class ResponseCourseDto {

    private String id;
    private String name;
    private int studypoints;
    private String professorId;

    public String getId() {
        return id;
    }

    public ResponseCourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseCourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public ResponseCourseDto setStudypoints(int studypoints) {
        this.studypoints = studypoints;
        return this;
    }

    public String getProfessorId() {
        return professorId;
    }

    public ResponseCourseDto setProfessorId(String professorId) {
        this.professorId = professorId;
        return this;
    }

}

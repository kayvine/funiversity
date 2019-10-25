package com.switchfully.rest.funiversity.webapi.dtos;

public class RequestCourseDto {

    private String name;
    private int studypoints;
    private String professorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public void setStudypoints(int studypoints) {
        this.studypoints = studypoints;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
}

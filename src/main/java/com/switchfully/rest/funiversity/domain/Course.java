package com.switchfully.rest.funiversity.domain;

import java.util.UUID;

public class Course {

    private final String id;
    private final String name;
    private final int studypoints;
    private final String professorId;

    public Course(String name, int studypoints, String professorId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.studypoints = studypoints;
        this.professorId = professorId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public String getProfessorId() {
        return professorId;
    }
}

package com.switchfully.rest.funiversity.domain;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CourseRepository {

    private final ConcurrentHashMap<String, Course> coursesById;

    public CourseRepository() {
        this.coursesById = new ConcurrentHashMap<>();
    }

    public Course save(Course course) {
        coursesById.put(course.getId(), course);
        return course;
    }

    public Course getById(String id) {
        var foundCourse = coursesById.get(id);
        if (foundCourse == null) {
            throw new IllegalArgumentException("No course could be found for id " + id);
        }
        return foundCourse;
    }

    public Collection<Course> getAll() {
        return coursesById.values();
    }

}

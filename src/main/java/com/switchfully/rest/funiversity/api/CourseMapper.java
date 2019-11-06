package com.switchfully.rest.funiversity.api;

import com.switchfully.rest.funiversity.domain.Course;
import com.switchfully.rest.funiversity.api.dtos.ResponseCourseDto;
import com.switchfully.rest.funiversity.api.dtos.RequestCourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course mapToDomain(RequestCourseDto dto) {
        return new Course(
                dto.getName(),
                dto.getStudypoints(),
                dto.getProfessorId());
    }

    public ResponseCourseDto mapToDto(Course course) {
        return new ResponseCourseDto()
                .setId(course.getId())
                .setName(course.getName())
                .setStudypoints(course.getStudypoints())
                .setProfessorId(course.getProfessorId());
    }

}

package com.switchfully.rest.funiversity.webapi;

import com.switchfully.rest.funiversity.domain.Course;
import com.switchfully.rest.funiversity.webapi.dtos.CourseDto;
import com.switchfully.rest.funiversity.webapi.dtos.RequestCourseDto;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course mapToDomain(RequestCourseDto dto) {
        return new Course(
                dto.getName(),
                dto.getStudypoints(),
                dto.getProfessorId());
    }

    public CourseDto mapToDto(Course course) {
        return new CourseDto()
                .setId(course.getId())
                .setName(course.getName())
                .setStudypoints(course.getStudypoints())
                .setProfessorId(course.getProfessorId());
    }

}

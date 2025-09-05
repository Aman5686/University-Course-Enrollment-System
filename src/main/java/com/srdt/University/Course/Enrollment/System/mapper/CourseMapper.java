package com.srdt.University.Course.Enrollment.System.mapper;

import com.srdt.University.Course.Enrollment.System.dto.CourseDTO;
import com.srdt.University.Course.Enrollment.System.entity.Course;
import com.srdt.University.Course.Enrollment.System.entity.Professor;

public class CourseMapper {
    public static CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setCode(course.getCode());
        dto.setTitle(course.getTitle());
        dto.setDepartment(course.getDepartment());

        if (course.getProfessor() != null) {
            dto.setProfessorId(course.getProfessor().getProfessorId());
        }
        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
        Course course = new Course();
        course.setCourseId(dto.getCourseId());
        course.setCode(dto.getCode());
        course.setTitle(dto.getTitle());
        course.setDepartment(dto.getDepartment());

        if (dto.getProfessorId() != null) {
            Professor professor = new Professor();
            professor.setProfessorId(dto.getProfessorId());
            course.setProfessor(professor);
        }
        return course;
    }
}

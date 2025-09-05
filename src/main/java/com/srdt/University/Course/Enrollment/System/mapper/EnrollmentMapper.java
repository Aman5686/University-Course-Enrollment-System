package com.srdt.University.Course.Enrollment.System.mapper;

import com.srdt.University.Course.Enrollment.System.dto.EnrollmentDTO;
import com.srdt.University.Course.Enrollment.System.entity.Course;
import com.srdt.University.Course.Enrollment.System.entity.Enrollment;
import com.srdt.University.Course.Enrollment.System.entity.Student;

public class EnrollmentMapper {
    public static EnrollmentDTO toDTO(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setStudentId(enrollment.getStudent().getStudentId());
        dto.setCourseId(enrollment.getCourse().getCourseId());
        return dto;
    }

    public static Enrollment toEntity(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        Student student = new Student();
        student.setStudentId(dto.getStudentId());

        Course course = new Course();
        course.setCourseId(dto.getCourseId());

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollment;
    }
}

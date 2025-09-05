package com.srdt.University.Course.Enrollment.System.mapper;

import com.srdt.University.Course.Enrollment.System.dto.StudentDTO;
import com.srdt.University.Course.Enrollment.System.entity.Profile;
import com.srdt.University.Course.Enrollment.System.entity.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        if (student.getProfile() != null) {
            dto.setAddress(student.getProfile().getAddress());
            dto.setPhone(student.getProfile().getPhone());
        }
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Profile profile = new Profile();
        profile.setAddress(dto.getAddress());
        profile.setPhone(dto.getPhone());

        profile.setStudent(student);
        student.setProfile(profile);

        return student;
    }
}

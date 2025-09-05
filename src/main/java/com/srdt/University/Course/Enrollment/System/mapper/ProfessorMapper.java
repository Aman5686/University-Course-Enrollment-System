package com.srdt.University.Course.Enrollment.System.mapper;

import com.srdt.University.Course.Enrollment.System.dto.ProfessorDTO;
import com.srdt.University.Course.Enrollment.System.entity.Professor;

public class ProfessorMapper {
    public static ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setProfessorId(professor.getProfessorId());
        dto.setName(professor.getName());
        dto.setEmail(professor.getEmail());
        dto.setDepartment(professor.getDepartment());
        return dto;
    }

    public static Professor toEntity(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setProfessorId(dto.getProfessorId());
        professor.setName(dto.getName());
        professor.setEmail(dto.getEmail());
        professor.setDepartment(dto.getDepartment());
        return professor;
    }
}

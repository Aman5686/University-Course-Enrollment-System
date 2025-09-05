package com.srdt.University.Course.Enrollment.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProfessorDTO {

    private Long professorId;
    private String name;
    private String email;
    private String department;


    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

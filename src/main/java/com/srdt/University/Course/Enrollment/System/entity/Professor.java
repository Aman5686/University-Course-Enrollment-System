package com.srdt.University.Course.Enrollment.System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "professors")
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    private String name;

    @Email(message = "Invalid Email Format!!")
    @Column(unique = true)
    @NotNull(message = "email is mandatory")
    private String email;
    private String department;

    @OneToMany(mappedBy = "professor")
    private Set<Course> courses;

//    public Long getProfessorId() {
//        return professorId;
//    }
//
//    public void setProfessorId(Long professorId) {
//        this.professorId = professorId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
}

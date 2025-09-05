package com.srdt.University.Course.Enrollment.System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}

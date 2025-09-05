package com.srdt.University.Course.Enrollment.System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(unique = true)
    @Pattern(regexp = "CRS-\\d{4}", message = "Must Follow This Format -> CRS-1234")
    private String code;

    private String title;
    private String department;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}

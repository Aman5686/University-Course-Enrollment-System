package com.srdt.University.Course.Enrollment.System.repository;

import com.srdt.University.Course.Enrollment.System.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT DISTINCT p FROM Professor p JOIN p.courses c WHERE c.department = :department")
    List<Professor> findProfesssorsByCourseDepartment(String department);
}

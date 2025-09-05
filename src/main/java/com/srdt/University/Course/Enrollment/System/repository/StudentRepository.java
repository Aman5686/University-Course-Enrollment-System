package com.srdt.University.Course.Enrollment.System.repository;

import com.srdt.University.Course.Enrollment.System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students s WHERE s.id NOT IN (SELECT student_id FROM enrollment)", nativeQuery = true)
    List<Student> findStudentWithNoEnrollment();
}

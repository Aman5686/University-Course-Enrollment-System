package com.srdt.University.Course.Enrollment.System.repository;

import com.srdt.University.Course.Enrollment.System.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Query("SELECT e FROM Enrollment e WHERE e.student.id = :studentId AND e.course.id = :courseId")
    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
}

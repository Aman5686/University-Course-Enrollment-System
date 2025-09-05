package com.srdt.University.Course.Enrollment.System.repository;

import com.srdt.University.Course.Enrollment.System.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE size(c.enrollments) > :count")
    List<Course> findCoursesWithEnrollmentGreaterThan(long count);

    @Query(value = "SELECT AVG(counts) FROM (SELECT COUNT(*) as counts FROM enrollment GROUP BY course_id) as sub", nativeQuery = true)
    Double findAverageStudentsPerCourse();
}

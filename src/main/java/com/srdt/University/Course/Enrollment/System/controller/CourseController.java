package com.srdt.University.Course.Enrollment.System.controller;

import com.srdt.University.Course.Enrollment.System.dto.CourseDTO;
import com.srdt.University.Course.Enrollment.System.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addCourse(@RequestBody CourseDTO dto) {
        try {
            CourseDTO saved = courseService.addCourse(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Course Created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/minenrollment/{count}")
    public ResponseEntity<List<CourseDTO>> findCourseWithMinEnrollment(@PathVariable long count) {
        return ResponseEntity.ok(courseService.findCoursesWithMinEnrollment(count));
    }

    @GetMapping("/averagestudents")
    public ResponseEntity<?> getAverageStudentsPerCourse() {
        return ResponseEntity.ok(Map.of("average", courseService.averageStudentsPerCourse()));
    }
}

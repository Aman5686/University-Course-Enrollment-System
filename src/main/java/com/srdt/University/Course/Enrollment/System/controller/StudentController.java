package com.srdt.University.Course.Enrollment.System.controller;

import com.srdt.University.Course.Enrollment.System.dto.EnrollmentDTO;
import com.srdt.University.Course.Enrollment.System.dto.StudentDTO;
import com.srdt.University.Course.Enrollment.System.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> registerStudent(@RequestBody StudentDTO dto) {
        try {
            StudentDTO saved = studentService.registerStudent(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getStudent(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestBody EnrollmentDTO dto) {
        try {
            studentService.enrollStudent(dto);
            return ResponseEntity.ok(Map.of("message", "Enrollment Successfull."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error" , e.getMessage()));
        }
    }

    @DeleteMapping("/unenroll")
    public ResponseEntity<?> unenroll(@RequestBody EnrollmentDTO dto) {
        try {
            studentService.removeEnrollment(dto);
            return ResponseEntity.ok(Map.of("message", "Enrollment Removed"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/no-enrollments")
    public ResponseEntity<List<StudentDTO>> studentsWithNoEnrollments() {
        return ResponseEntity.ok(studentService.studentsWithNoEnrollments());
    }
}

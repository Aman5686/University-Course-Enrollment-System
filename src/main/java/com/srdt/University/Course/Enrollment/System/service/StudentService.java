package com.srdt.University.Course.Enrollment.System.service;

import com.srdt.University.Course.Enrollment.System.dto.EnrollmentDTO;
import com.srdt.University.Course.Enrollment.System.dto.StudentDTO;
import com.srdt.University.Course.Enrollment.System.entity.Course;
import com.srdt.University.Course.Enrollment.System.entity.Enrollment;
import com.srdt.University.Course.Enrollment.System.entity.Student;
import com.srdt.University.Course.Enrollment.System.mapper.EnrollmentMapper;
import com.srdt.University.Course.Enrollment.System.mapper.StudentMapper;
import com.srdt.University.Course.Enrollment.System.repository.CourseRepository;
import com.srdt.University.Course.Enrollment.System.repository.EnrollmentRepository;
import com.srdt.University.Course.Enrollment.System.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService (StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Transactional
    public StudentDTO registerStudent(StudentDTO dto) {
        Student s = StudentMapper.toEntity(dto);
        Student saved = studentRepository.save(s);
        return StudentMapper.toDTO(saved);
    }

    public StudentDTO getStudent(Long id) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found!!"));
        return StudentMapper.toDTO(s);
    }

    @Transactional
    public void enrollStudent(EnrollmentDTO dto) {
        Student s = studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new RuntimeException("Student Not Found!!"));
        Course c = courseRepository.findById(dto.getCourseId()).orElseThrow(() -> new RuntimeException("Course Not Found"));

        if (enrollmentRepository.findByStudentIdAndCourseId(dto.getStudentId(), dto.getCourseId()).isPresent()) {
            throw new RuntimeException("Student Already Exists");
        }

        Enrollment e = EnrollmentMapper.toEntity(dto);
        e.setStudent(s);
        e.setCourse(c);
        enrollmentRepository.save(e);
    }

    @Transactional
    public void removeEnrollment(EnrollmentDTO dto) {
        Enrollment e = enrollmentRepository.findByStudentIdAndCourseId(dto.getStudentId(), dto.getCourseId()).orElseThrow(() -> new RuntimeException("Enrollment Not Found!!"));
        enrollmentRepository.delete(e);
    }

    public List<StudentDTO> studentsWithNoEnrollments() {
        return studentRepository.findStudentWithNoEnrollment().stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
}

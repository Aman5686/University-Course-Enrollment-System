package com.srdt.University.Course.Enrollment.System.service;

import com.srdt.University.Course.Enrollment.System.dto.CourseDTO;
import com.srdt.University.Course.Enrollment.System.entity.Course;
import com.srdt.University.Course.Enrollment.System.entity.Professor;
import com.srdt.University.Course.Enrollment.System.mapper.CourseMapper;
import com.srdt.University.Course.Enrollment.System.repository.CourseRepository;
import com.srdt.University.Course.Enrollment.System.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    public CourseService (CourseRepository courseRepository, ProfessorRepository professorRepository) {
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    @Transactional
    public CourseDTO addCourse(CourseDTO dto) {
        Professor prof = professorRepository.findById(dto.getProfessorId()).orElseThrow(() -> new RuntimeException("Professor Not Found!!"));
        Course c = CourseMapper.toEntity(dto);
        c.setProfessor(prof);
        Course saved = courseRepository.save(c);
        return CourseMapper.toDTO(saved);
    }

    public List<CourseDTO> findCoursesWithMinEnrollment(long min) {
        return courseRepository.findCoursesWithEnrollmentGreaterThan(min).stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Double averageStudentsPerCourse() {
        Double avg = courseRepository.findAverageStudentsPerCourse();
        return avg != null ? avg : 0.0;
    }
}

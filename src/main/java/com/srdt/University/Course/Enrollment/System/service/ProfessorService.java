package com.srdt.University.Course.Enrollment.System.service;

import com.srdt.University.Course.Enrollment.System.dto.ProfessorDTO;
import com.srdt.University.Course.Enrollment.System.entity.Professor;
import com.srdt.University.Course.Enrollment.System.mapper.ProfessorMapper;
import com.srdt.University.Course.Enrollment.System.repository.CourseRepository;
import com.srdt.University.Course.Enrollment.System.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public ProfessorService(ProfessorRepository professorRepository, CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public ProfessorDTO addProfessor(ProfessorDTO dto) {
        Professor p = ProfessorMapper.toEntity(dto);
        Professor saved = professorRepository.save(p);
        return ProfessorMapper.toDTO(saved);
    }

    @Transactional
    public ProfessorDTO updateProcessor(Long id, ProfessorDTO dto) {
        Professor p = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor Not Found!!"));
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setDepartment(dto.getDepartment());
        professorRepository.save(p);
        return ProfessorMapper.toDTO(p);
    }

    public List<ProfessorDTO> findByDepartment(String dept) {
        return professorRepository.findProfesssorsByCourseDepartment(dept).stream()
                .map(ProfessorMapper::toDTO)
                .collect(Collectors.toList());
    }
}

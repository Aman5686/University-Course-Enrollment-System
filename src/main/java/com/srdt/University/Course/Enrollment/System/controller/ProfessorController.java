package com.srdt.University.Course.Enrollment.System.controller;

import com.srdt.University.Course.Enrollment.System.dto.ProfessorDTO;
import com.srdt.University.Course.Enrollment.System.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {
    private final ProfessorService professorService;
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addProfessor(@RequestBody ProfessorDTO dto) {
        try {
            ProfessorDTO saved = professorService.addProfessor(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfessor(@PathVariable Long id, @RequestBody ProfessorDTO dto) {
        try {
            return ResponseEntity.ok(professorService.updateProcessor(id, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Professor Not Found!!"));
        }
    }

    @DeleteMapping("/department/{dept}")
    public ResponseEntity<List<ProfessorDTO>> getProfessorsByDepartment(@PathVariable String dept) {
        return ResponseEntity.ok(professorService.findByDepartment(dept));
    }

}

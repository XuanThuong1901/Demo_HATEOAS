package com.demo.knowledge.demo.controller;

import com.demo.knowledge.demo.DTO.school.SchoolResponseDTO;
import com.demo.knowledge.demo.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private ModelMapper modelMapper;

    private final SchoolRepository schoolRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchool(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(
                modelMapper.map(schoolRepository.findById(id).orElse(null),
                        SchoolResponseDTO.class));
    }
}

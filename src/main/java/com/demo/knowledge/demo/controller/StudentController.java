package com.demo.knowledge.demo.controller;

import com.demo.knowledge.demo.entity.Student;
import com.demo.knowledge.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(studentRepository.findById(id).orElse(null));
    }
}

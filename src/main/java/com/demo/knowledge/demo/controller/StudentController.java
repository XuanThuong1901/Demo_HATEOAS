package com.demo.knowledge.demo.controller;

import com.demo.knowledge.demo.entity.Student;
import com.demo.knowledge.demo.repository.StudentRepository;
import com.demo.knowledge.demo.service.interf.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final IStudentService iStudentService;

    private static HashMap<Integer, Student> studentMap;
    static {
        studentMap = new HashMap<Integer, Student>();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(iStudentService.getStudentById(id));
    }
}

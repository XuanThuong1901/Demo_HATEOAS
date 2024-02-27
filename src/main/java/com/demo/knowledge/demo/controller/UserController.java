package com.demo.knowledge.demo.controller;

import com.demo.knowledge.demo.DTO.user.UserRequestDTO;
import com.demo.knowledge.demo.service.interf.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService iUserService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserRequestDTO requestDTO){
        return ResponseEntity.ok(iUserService.createUser(requestDTO));
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(iUserService.getAllUser());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable(name = "id") int id){

        return ResponseEntity.ok(iUserService.getUser(id));
    }
}

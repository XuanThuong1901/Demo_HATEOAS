package com.demo.knowledge.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_school")
    private int idSchool;

    @Column(name = "name_school", nullable = false)
    private String nameSchool;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Student> studentList;
}

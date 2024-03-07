package com.demo.knowledge.demo.DTO.sutdent;

import com.demo.knowledge.demo.DTO.school.SchoolResponseDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private int idStudent;
    private String fullName;
    private String address;
    private SchoolResponseDTO schoolResponseDTO;
}

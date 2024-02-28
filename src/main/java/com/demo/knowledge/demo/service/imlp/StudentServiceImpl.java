package com.demo.knowledge.demo.service.imlp;

import com.demo.knowledge.demo.DTO.school.SchoolResponseDTO;
import com.demo.knowledge.demo.DTO.sutdent.StudentResponseDTO;
import com.demo.knowledge.demo.entity.Student;
import com.demo.knowledge.demo.repository.StudentRepository;
import com.demo.knowledge.demo.service.interf.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;

    private final StudentRepository studentRepository;

    public StudentResponseDTO getStudentById(int id){
//        Student student = studentRepository.findById(id);
        StudentResponseDTO responseDTO = modelMapper.map(studentRepository.findById(id)
                .orElse(null), StudentResponseDTO.class);

        SchoolResponseDTO schoolResponseDTO = webClient.get().uri("/school/"+2)
                .retrieve().bodyToMono(SchoolResponseDTO.class).block();

        responseDTO.setSchoolResponseDTO(schoolResponseDTO);
        return responseDTO;
    }

}

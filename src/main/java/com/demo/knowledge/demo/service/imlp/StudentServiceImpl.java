package com.demo.knowledge.demo.service.imlp;

import com.demo.knowledge.demo.DTO.school.SchoolResponseDTO;
import com.demo.knowledge.demo.DTO.sutdent.StudentResponseDTO;
import com.demo.knowledge.demo.entity.Student;
import com.demo.knowledge.demo.repository.StudentRepository;
import com.demo.knowledge.demo.service.interf.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
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

    private RabbitTemplate rabbit;

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

    @Override
    public void sendStudent(int id) {

        // -- Send --
        Student student = studentRepository.findById(id).orElse(null);
        MessageConverter converter = rabbit.getMessageConverter();
        MessageProperties props = new MessageProperties();
        props.setHeader("SET_HEADER", "WEB");
        Message message = converter.toMessage(student, props);
        rabbit.send(message);

        // -- Convert and Send --
        rabbit.convertAndSend("demo.student", student,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        MessageProperties props = message.getMessageProperties();
                        props.setHeader("SET_HEADER", "WEB");
                        return message;
                    }
                });
    }

//    public String createStudent()

}

package com.demo.knowledge.demo.service.imlp;

import com.demo.knowledge.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitReceiveStudentServiceImpl {
    private RabbitTemplate rabbit;
    private MessageConverter converter;

    public Student receiveStudent(){
        Message message = rabbit.receive("demo.student");
        return message != null ? (Student) converter.fromMessage(message)
                : null;
    }

    public Student receiveStudent2(){
        Message message = rabbit.receive("demo.student.student-key", 30000);
        return message != null ? (Student) converter.fromMessage(message)
                : null;
    }

//    public
}

//package com.demo.knowledge.demo.service.imlp;
//
//import com.demo.knowledge.demo.entity.Student;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Service
//@RequiredArgsConstructor
//public class StudentTestWebClientService {
//
//    private final WebClient webClient;
//
//    public Mono<Student> createStudent(Student student) {
//
//        Mono<Student> employeeMono = webClient.post()
//                .uri("/student")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .body(Mono.just(student), Student.class)
//                .retrieve()
//                .bodyToMono(Student.class);
//
//        return employeeMono;
//    }
//}

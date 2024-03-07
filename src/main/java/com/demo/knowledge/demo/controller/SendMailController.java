package com.demo.knowledge.demo.controller;

import com.demo.knowledge.demo.service.interf.ISendMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send_mail")
public class SendMailController {

    private final ISendMailService iSendMailService;

    @GetMapping("/simple")
    public ResponseEntity<?> sendSimpleMail(){
        return ResponseEntity.ok(iSendMailService.sendSimpleMail("nxthuong0119@gmail.com", "Love baby", "Hello baby"));
    }
}

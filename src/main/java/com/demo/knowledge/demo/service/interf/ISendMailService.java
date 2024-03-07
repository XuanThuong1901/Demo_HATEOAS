package com.demo.knowledge.demo.service.interf;

import org.springframework.messaging.MessagingException;

import java.util.List;

public interface ISendMailService {
    String sendSimpleMail(String toMail, String subject, String message) throws MessagingException;
    String sendAttachmentEmail(String toMail, String message, List<String> pathList) throws MessagingException, jakarta.mail.MessagingException;
//    String sendHtmlEmail(String toMail, String message,);
}

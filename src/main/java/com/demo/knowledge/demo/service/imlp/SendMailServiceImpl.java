package com.demo.knowledge.demo.service.imlp;

import com.demo.knowledge.demo.service.interf.ISendMailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendMailServiceImpl implements ISendMailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public String sendSimpleMail(String toMail, String subject, String message) throws MessagingException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        this.javaMailSender.send(mailMessage);
        return "Send to";
    }

    @Override
    public String sendAttachmentEmail(String toMail, String message, List<String> pathList) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart);

        helper.setTo(toMail);
        helper.setSubject("Test email with attachments");
        helper.setText("Hello, Im testing email with attachments!");

        for (String path: pathList){
            FileSystemResource file = new FileSystemResource(new File(path));
            helper.addAttachment("file", file);
        }

        javaMailSender.send(mimeMessage);

        return "Email Sent!";

    }
}

package com.company.emailservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class EmailService {

        private final JavaMailSender javaMailSender;


@Scheduled (fixedRate = 50000)
        public  void sendEmail() {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("nbrismayilova@gmail.com");
            msg.setFrom("nbrismayilova@gmail.com");
            msg.setSubject("First email");
            msg.setText("Hello, it is my first email!");
            javaMailSender.send(msg);
            log.info("Your email delivered!");
        }


        public void sendEmailWithAttachment() throws MessagingException {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo("nbrismayilova@gmail.com");
            helper.setFrom("nbrismayilova@gmail.com");
            helper.setSubject("Testing from Spring Boot");

            helper.setText("<h1>Check attachment for image!</h1>", true);

            helper.addAttachment("cab.png", new ClassPathResource("cab.png"));

            javaMailSender.send(msg);
            log.info("Your attachment has been sent");
        }
    }



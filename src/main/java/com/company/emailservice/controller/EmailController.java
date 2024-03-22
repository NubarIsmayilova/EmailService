package com.company.emailservice.controller;

import com.company.emailservice.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequiredArgsConstructor
    public class EmailController {

        private final EmailService emailService;


        @GetMapping("/emailing")
        public void welcomeEmail () {
            emailService.sendEmail();

        }

        @GetMapping("/attachEmail")
        public void attachEmail () throws MessagingException {
            emailService.sendEmailWithAttachment();

        }


    }



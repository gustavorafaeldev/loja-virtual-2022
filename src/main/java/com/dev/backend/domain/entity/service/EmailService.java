package com.dev.backend.domain.entity.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public String enviarEmailTexto(String destinatario, String titulo, String menssagem) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("gustavolira123321@gmail.com");
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(titulo);
            simpleMailMessage.setText(menssagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado";
        } catch (Exception ex) {
            return "Erro ao enviar o email";
        }
    }
}

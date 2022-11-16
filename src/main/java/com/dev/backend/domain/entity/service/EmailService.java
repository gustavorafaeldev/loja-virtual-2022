package com.dev.backend.domain.entity.service;

import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final Configuration fmConfiguration;

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

    public void enviarEmailTemplate(String destinatario, String titulo, Map<String, Object> propriedades) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(titulo);
            mimeMessageHelper.setFrom("gustavolira123321@gmail.com");
            mimeMessageHelper.setTo(destinatario);
            mimeMessageHelper.setText(getConteudoTemplate(propriedades), true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String getConteudoTemplate(Map<String, Object> model) {
        StringBuffer content = new StringBuffer();

        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString
                    (fmConfiguration.getTemplate("email-recuperacao-codigo.flth"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ashutosh
 */
public class MailSender {
    public void sendEmail(String email,String sub,String content) throws IOException {

        final String username = "mishraashu******1@gmail.com";
        final String password = "**********";
        final String fromemail = username;
        final String subject = sub;
        final String msg = content;
        final String toemail =email;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromemail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toemail));
            message.setSubject(subject);
            message.setText(msg);

            Transport.send(message);
            
            //out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}

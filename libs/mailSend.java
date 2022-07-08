package utilities;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;

class mailSend{
    public static void main(String [] args){

        String to="vladimirnagornov831@gmail.com";//change accordingly
        final String user="vladimirnagornov831@gmail.com";//change accordingly
        final String password="$zayROQhEptableptabl";//change accordingly

        //1) get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");//change accordingly
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Message Aleart");

            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("This is message body");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);

            message.setContent(multipart );
            Transport.send(message);

            System.out.println("message sent....");
        }catch (MessagingException ex) {ex.printStackTrace();}
    }
}
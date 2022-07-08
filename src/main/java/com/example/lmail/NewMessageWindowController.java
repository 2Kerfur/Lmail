package com.example.lmail;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class NewMessageWindowController {

    @FXML
    private TextField Mail_Destination;

    @FXML
    private TextField Mail_Subject;

    @FXML
    private TextArea Mail_Message;

    String user_login;
    String user_password;

    @FXML
    protected void OnSendButtonPressed() throws IOException {
        FileInputStream fstream = new FileInputStream("login_info.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        int counter = 0;

        while ((strLine = br.readLine()) != null)   {
            if (counter == 1) //read second line
            {
                user_password = strLine;
            } else { //read first line
                counter += 1;
                user_login = strLine;
            }
        }
        SendEmail();

    }

    void SendEmail() {
        // Recipient's email ID needs to be mentioned.
        String to = user_login;

        // Sender's email ID needs to be mentioned
        String from = Mail_Destination.getText();

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.mail.ru";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {


                return new PasswordAuthentication(user_login, user_password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(Mail_Subject.getText());

            // Now set the actual message
            message.setText(Mail_Message.getText());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}

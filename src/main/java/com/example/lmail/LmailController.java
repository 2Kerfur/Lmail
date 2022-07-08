package com.example.lmail;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//mail sender
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class LmailController {


    @FXML
    protected void OnSettingsMenubarClick() throws IOException
    {
        SettingsWindow settingsW = new SettingsWindow();
        settingsW.CreateWindow();
    }

    @FXML
    protected void OnNewMailButtonClick() throws IOException
    {
        NewMessageWindow newmessageW = new NewMessageWindow();
        newmessageW.CreateWindow();
    }


}


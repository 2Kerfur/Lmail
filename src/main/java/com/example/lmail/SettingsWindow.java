package com.example.lmail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;



import java.io.IOException;


public class SettingsWindow {
    public String user_login;
    public String user_password;

    void CreateWindow() throws IOException {
        FXMLLoader settings_desing = new FXMLLoader(LmailApp.class.getResource("settings_screen.fxml"));
        Stage settings_stage = new Stage();
        settings_stage.setTitle("Settings");
        settings_stage.setScene(new Scene(settings_desing.load(), 450, 450));
        settings_stage.show();
    }
}

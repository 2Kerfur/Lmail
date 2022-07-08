package com.example.lmail;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewMessageWindow {
    void CreateWindow() throws IOException {
        FXMLLoader newMessage_design = new FXMLLoader(
                LmailApp.class.getResource("new_message_screen.fxml"));
        Stage message_stage = new Stage();
        message_stage.setTitle("Create new mail");
        message_stage.setScene(new Scene(newMessage_design.load(), 450, 450));
        message_stage.show();
    }
}

package com.example.lmail;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SettingsWindowController {

    @FXML
    private TextField User_Login;

    @FXML
    private PasswordField User_Password;

    @FXML
    protected void OnLoginButtonClick() throws IOException {
        try {
            File myObj = new File("login_info.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter("login_info.txt", StandardCharsets.UTF_8);
        writer.println(User_Login.getText());
        writer.println(User_Password.getText());
        writer.close();

    }


}

package com.example.lmail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;



public class LmailApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LmailApp.class.getResource("main_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        stage.setTitle("Lmail");
        //stage.setResizable(false);
        Image AppIcon = new Image("icon.png");
        var textField = new TextField("Hello World!");
        stage.getIcons().add(AppIcon);

        //settings window
        //FXMLLoader settings_desing = new FXMLLoader(LmailApp.class.getResource("main_screen.fxml"));
        ///Stage settings_stage = new Stage();
        //settings_stage.setTitle("My Newd Stage Title");
        //settings_stage.setScene(new Scene(settings_desing.load(), 450, 450));
        //settings_stage.show();
        //settings window

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
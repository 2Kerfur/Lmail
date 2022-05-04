
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class MyFirstApp extends Application {

    //setting up email send variables



    String Gmail_url = "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&hl=en&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en&flowName=GlifWebSignIn&flowEntry=SignUp";
    String Outlook_url = "https://signup.live.com/signup?lcid=1033&wa=wsignin1.0&rpsnv=13&ct=1623924418&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26signup%3d1%26RpsCsrfState%3dce499cf9-b337-2549-3253-eb71077700e5&id=292841&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015&lic=1&uaid=a53a7d3d0df14e65bcfae13c745a9bad";
    String Mail_url = "https://account.mail.ru/signup";


    String email = "none";
    String password = "none";
    String to = "vladimirnagornov831@gmail.com";
    String from = "vladimirnagornov831@gmail.com";
    String host = "localhost";


    @Override
    public void init() throws Exception {
        System.out.println("Before the main process");
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Lmail login");
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);


        Button Login_button = new Button("Login");
        Login_button.setTranslateX(300);
        Login_button.setTranslateY(15);

        Text text = new Text();
        GridPane.setConstraints(text, 1, 3);
        text.setText("   Don't have an email? Lets create one:");


        Button Gmail_button = new Button("Gmail");
        //Gmail_button.setGraphic(new ImageView(imageDecline));
        Gmail_button.setTranslateX(100);
        Gmail_button.setTranslateY(100);

        Button Outlook_button = new Button("Outlook");
        Outlook_button.setTranslateX(150);
        Outlook_button.setTranslateY(100);

        Button Mail_button = new Button("Mail.ru");
        Mail_button.setTranslateX(212);
        Mail_button.setTranslateY(100);


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Email:");
        GridPane.setConstraints(nameLabel, 0,0);

        TextField emailInput = new TextField();
        emailInput.setPromptText("email");
        GridPane.setConstraints(emailInput, 1, 0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Login_button.setOnAction(Event -> setData(emailInput.getText(), passInput.getText() ));
        Gmail_button.setOnAction(Event -> OpenBrowser(Gmail_url));
        Outlook_button.setOnAction(Event -> OpenBrowser(Outlook_url));
        Mail_button.setOnAction(Event -> OpenBrowser(Mail_url));

        grid.getChildren().addAll(emailInput, nameLabel, passLabel, passInput, text);
        grid.getChildren().addAll(Login_button, Mail_button, Gmail_button, Outlook_button);

        Scene scene = new Scene(grid, 400, 180);

        stage.setScene(scene);
        stage.show();

    }

    public void setData(String logn, String pass) {
        email = logn;
        password=pass;
        System.out.println(email);
        System.out.println(password);
    }

    public void OpenBrowser(String url) {
        System.out.println("Browser opened");
        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            //specify the protocol along with the URL
            URI oURL = new URI(url);
            desktop.browse(oURL);
        } catch (URISyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void stop() throws Exception {
        System.out.println("After main process");
    }
}

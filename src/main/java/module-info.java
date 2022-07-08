module com.example.lmail {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.mail;
    requires activation;

    opens com.example.lmail to javafx.fxml;
    exports com.example.lmail;
}
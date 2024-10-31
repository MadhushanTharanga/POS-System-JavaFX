package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtEmail;
    public TextField txtPassword;

    public void loginOnAction(ActionEvent actionEvent) {
        
    }

    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RegisterForm");
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("/view/"+location + ".fxml");
        Stage stage = (Stage) loginContext.getScene().getWindow();
        Parent parent = FXMLLoader.load(resource);
        Scene scene = new Scene(parent);
        stage.setScene(scene);


    }
}

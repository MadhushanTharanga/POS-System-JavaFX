package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.User;

import java.io.IOException;
import java.net.URL;

public class RegisterFormController {
    public AnchorPane regContext;
    public TextField txtEmail;
    public TextField txtName;
    public TextField txtPassword;

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        if (txtEmail.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Enter Email", ButtonType.CLOSE).show();
            return;
        } else if (txtName.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Please Enter Name" , ButtonType.CLOSE).show();
            return;
        } else if (txtPassword.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Please Enter Password", ButtonType.CLOSE).show();
            return;
        }
        User user = new User(txtEmail.getText(),txtName.getText(),txtPassword.getText());
        Database.userTable.add(user);
        new Alert(Alert.AlertType.INFORMATION,"Successfully!!", ButtonType.OK).show();
        setUi("LoginForm");

    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("/view/" + location + ".fxml");
        Stage stage = (Stage) regContext.getScene().getWindow();
        Parent parent = FXMLLoader.load(resource);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }
}

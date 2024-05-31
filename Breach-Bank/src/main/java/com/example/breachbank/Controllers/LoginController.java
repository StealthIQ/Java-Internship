package com.example.breachbank.Controllers;

import com.example.breachbank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Label username_label;
    public TextField username_input_field;
    public Label password_label;
    public TextField password_input_field;
    public Button login_button;
    public Label login_error_code_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) login_error_code_label.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showClientWindow();

    }
}

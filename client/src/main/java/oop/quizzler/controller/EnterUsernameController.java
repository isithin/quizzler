package oop.quizzler.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EnterUsernameController {
    //Views
    @FXML private TextField username;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    @FXML
    private void playQuiz() {
        if ((username.getText()).length() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a username", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            try {
                StartQuizzler.createNewAttempt(username.getText(), StartQuizzler.getActiveQuiz()); 
                StartQuizzler.setRoot("answerQuestion");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

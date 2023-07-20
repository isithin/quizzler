package oop.quizzler.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NamingQuizController {
    @FXML private TextField quizName;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    
    
    @FXML
    private void switchToEditor(ActionEvent event) {
        if ((quizName.getText()).length() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a Quizname", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            try {
                System.out.println(quizName.getText());
                StartQuizzler.createNewQuiz(quizName.getText());
                StartQuizzler.setRoot("selectQuestionType");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

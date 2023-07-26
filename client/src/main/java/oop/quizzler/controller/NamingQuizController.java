package oop.quizzler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;

public class NamingQuizController {
    //Views
    @FXML private TextField quizName;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    @FXML
    private void switchToEditor() {
        if ((quizName.getText()).length() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a Quizname", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            Connection connection = StartQuizzler.getConnection();
            List<String> quizList = Arrays.asList(connection.getAllQuizNamesFromServer());
            if (quizList.contains(quizName.getText())) {
                Alert alert = new Alert(AlertType.NONE, "Quizname already exists", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    alert.close();
                }
            } else {
                try {
                    StartQuizzler.createNewQuiz(quizName.getText());
                    StartQuizzler.setRoot("selectQuestionType");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

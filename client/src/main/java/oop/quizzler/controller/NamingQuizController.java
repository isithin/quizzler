package oop.quizzler.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;

/**
 * FXML Controller class for namingQuiz.fxml
 */
public class NamingQuizController {
    //Views
    @FXML private TextField quizName;

    /**
     * @throws IOException
     * Switches to the menu view.
     */
    @FXML
    private void switchToMenu() throws IOException {
        InitQuizzler.setRoot("menu");
    }

    /**
     * Creates a new quiz with the entered name and switches to the selectQuestionType view.
     * If no quizname is entered, an alert is shown.
     * If the quizname already exists, an alert is shown. (Quiznames have to be unique to use them as id)
     */
    @FXML
    private void switchToEditor() {
        if ((quizName.getText()).length() == 0) {
            Alert alert = new Alert(AlertType.NONE, "Please enter a Quizname", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } else {
            Connection connection = InitQuizzler.getConnection();
            List<String> quizList = Arrays.asList(connection.getAllQuizNamesFromServer());
            if (quizList.contains(quizName.getText())) {
                Alert alert = new Alert(AlertType.NONE, "Quizname already exists", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    alert.close();
                }
            } else {
                try {
                    InitQuizzler.createNewQuiz(quizName.getText());
                    InitQuizzler.setRoot("selectQuestionType");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

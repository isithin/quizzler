package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ViewScoreController implements Initializable{
    //Views
    @FXML private Label scoreResults;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    @FXML
    private void switchToHighscores() throws IOException {
        StartQuizzler.setRoot("viewHighscores");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int score = StartQuizzler.getAttempt().getScore();
        int numberOfQuestions = StartQuizzler.getActiveQuiz().getQuestionsInt();
        scoreResults.setText(score + "/" + numberOfQuestions);
       
    }   
}

package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import oop.quizzler.model.Attempt;
import oop.quizzler.model.Connection;

public class ViewHighscoresController implements Initializable{
   
    //Views
    @FXML private ListView<String> scoreListView;

    private ArrayList<Attempt> attemptList;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    private void getItem(){
        try {
            Connection connection = StartQuizzler.getConnection();
            attemptList = connection.getQuizFromServer(StartQuizzler.getActiveQuiz().getName()).getAttempts();
            
        } catch(Exception e) {
            e.printStackTrace();
        }  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getItem();
        List<String> highscoreList = new ArrayList<String>();
        for(Attempt attempt: attemptList) {
            highscoreList.add(attempt.getUsername() + ": " + attempt.getScore() + "/" + StartQuizzler.getActiveQuiz().getQuestionsInt());
        }
        scoreListView.setItems(FXCollections.observableList(highscoreList));
    }   
    
}

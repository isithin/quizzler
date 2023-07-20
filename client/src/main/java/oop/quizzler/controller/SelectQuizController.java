package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import oop.quizzler.model.Connection;

public class SelectQuizController implements Initializable{
    //Views
    @FXML private ListView<String> quizListView;

    private  List<String> quizList;
    private Connection connection;

    @FXML
    private void switchToMenu() throws IOException {
        StartQuizzler.setRoot("menu");
    }

    @FXML
    private void switchToEnterUsername() throws IOException{
        StartQuizzler.setActiveQuiz(connection.getQuizFromServer(quizListView.getSelectionModel().getSelectedItem()));
        StartQuizzler.setRoot("enterUsername");
    }

    @FXML
    private void deleteQuiz() throws IOException{
        //todo
    }
    
    private void getItem(){
        try {
            connection = StartQuizzler.getConnection();
            quizList = Arrays.asList(connection.getAllQuizNamesFromServer());   
        } catch(Exception e) {
            e.printStackTrace();
        }  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getItem();
        quizListView.setItems(FXCollections.observableList(quizList));
    }    
}
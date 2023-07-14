package oop.quizzler.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.quizzler.model.Attempt;

import java.io.IOException;

// import Quiz class from module interface
import oop.quizzler.model.Quiz;



public class StartQuizzler extends Application {

    private static Scene scene;
    private Stage stage;

    private static Quiz newQuiz;
    private static Quiz activeQuiz;
    private static Attempt attempt;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        try{
            scene = new Scene(loadFXML("menu"), 640, 480);
            stage.setScene(scene);
            stage.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartQuizzler.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void createNewQuiz(String name) {
        StartQuizzler.newQuiz = new Quiz(name);
    }

    public static Quiz getNewQuiz() {
        return StartQuizzler.newQuiz;
    }

    public static void createNewAttempt(String username, Quiz activeQuiz) {
        StartQuizzler.attempt = new Attempt(username, activeQuiz);
    }

    public static Attempt getAttempt() {
        return StartQuizzler.attempt;
    }

    public static void setActiveQuiz(Quiz activeQuiz) {
        StartQuizzler.activeQuiz = activeQuiz;
    }

    public static Quiz getActiveQuiz() {
        return StartQuizzler.activeQuiz;
    }

    public static void main(String[] args) {
        launch();
    }

}
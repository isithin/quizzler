package oop.quizzler.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.quizzler.model.Attempt;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import java.io.IOException;
import oop.quizzler.model.Quiz;

public class InitQuizzler extends Application {

    private static Scene scene;
    private Stage stage;

    private static Quiz newQuiz;
    private static Quiz activeQuiz;
    private static Attempt attempt;
    private static Connection connection;
    private static DisplayType displayType;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        try{
            scene = new Scene(loadFXML("welcome"), 640, 480);
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
        FXMLLoader fxmlLoader = new FXMLLoader(InitQuizzler.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void createNewQuiz(String name) {
        InitQuizzler.newQuiz = new Quiz(name);
    }

    public static Quiz getNewQuiz() {
        return InitQuizzler.newQuiz;
    }

    public static void createNewAttempt(String username, Quiz activeQuiz) {
        InitQuizzler.attempt = new Attempt(username, activeQuiz);
    }

    public static Attempt getAttempt() {
        return InitQuizzler.attempt;
    }

    public static void setActiveQuiz(Quiz activeQuiz) {
        InitQuizzler.activeQuiz = activeQuiz;
    }

    public static Quiz getActiveQuiz() {
        return InitQuizzler.activeQuiz;
    }

    public static void setConnection(Connection connection) {
        InitQuizzler.connection = connection;
    }

    public static Connection getConnection() {
        return InitQuizzler.connection;
    }

    public static void setDisplayType(DisplayType displayType) {
        InitQuizzler.displayType = displayType;
    }

    public static DisplayType getDisplayType() {
        return InitQuizzler.displayType;
    }

    public static void main(String[] args) {
        launch();
    }

}
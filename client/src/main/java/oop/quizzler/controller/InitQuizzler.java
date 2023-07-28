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

/**
 * Class used as a starting and turning point for the application. Importent for
 * the communication and change between the different views. Contains helper
 * methods and objects for the controllers.
 */
public class InitQuizzler extends Application {
	private static Scene scene;

	private Stage stage;

	private static Quiz newQuiz;

	private static Quiz activeQuiz;

	private static Attempt attempt;

	private static Connection connection;

	private static DisplayType displayType;

	/**
	 * @param stage
	 * @throws IOException Starts the application with the welcome view and sets the
	 *                     stage.
	 */
	@Override
	public void start(Stage stage) throws IOException {
		this.stage = stage;
		try {
			scene = new Scene(loadFXML("welcome"), 640, 480);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param fxml
	 * @throws IOException Changes the view to the view specified in the parameter.
	 */
	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * @param fxml
	 * @return
	 * @throws IOException Loads the fxml file specified in the parameter.
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(InitQuizzler.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * @param name Creates a new quiz with the name specified in the parameter.
	 */
	public static void createNewQuiz(String name) {
		InitQuizzler.newQuiz = new Quiz(name);
	}

	/**
	 * @return Returns the new quiz.
	 */
	public static Quiz getNewQuiz() {
		return InitQuizzler.newQuiz;
	}

	/**
	 * @param username
	 * @param activeQuiz Creates a new attempt with the username and active quiz
	 *                   specified in the parameters.
	 */
	public static void createNewAttempt(String username, Quiz activeQuiz) {
		InitQuizzler.attempt = new Attempt(username, activeQuiz);
	}

	/**
	 * @return Returns the attempt.
	 */
	public static Attempt getAttempt() {
		return InitQuizzler.attempt;
	}

	/**
	 * @param activeQuiz Sets the active quiz to the quiz specified in the
	 *                   parameter.
	 */
	public static void setActiveQuiz(Quiz activeQuiz) {
		InitQuizzler.activeQuiz = activeQuiz;
	}

	/**
	 * @return Returns the active quiz.
	 */
	public static Quiz getActiveQuiz() {
		return InitQuizzler.activeQuiz;
	}

	/**
	 * @param connection Sets the connection to the given connection specified in
	 *                   the parameter.
	 */
	public static void setConnection(Connection connection) {
		InitQuizzler.connection = connection;
	}

	/**
	 * @return Returns the connection.
	 */
	public static Connection getConnection() {
		return InitQuizzler.connection;
	}

	/**
	 * @param displayType Sets the display type to the given display type specified
	 *                    in the parameter. Helps to keep track of the current
	 *                    display type of the question throughout the different
	 *                    views.
	 */
	public static void setDisplayType(DisplayType displayType) {
		InitQuizzler.displayType = displayType;
	}

	/**
	 * @return Returns the display type.
	 */
	public static DisplayType getDisplayType() {
		return InitQuizzler.displayType;
	}

	/**
	 * @param args Launches the application.
	 */
	public static void main(String[] args) {
		launch();
	}
}

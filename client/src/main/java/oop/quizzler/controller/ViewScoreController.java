package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class for viewScore.fxml
 */
public class ViewScoreController implements Initializable {
	// Views
	@FXML
	private Label scoreResults;

	/**
	 * Switches to the menu view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToMenu() throws IOException {
		InitQuizzler.setRoot("menu");
	}

	/**
	 * Switches to the highscores view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToHighscores() throws IOException {
		InitQuizzler.setRoot("viewHighscores");
	}

	/**
	 * Initializes the view. Gets the score from the attempt and displays it.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		int score = InitQuizzler.getAttempt().getScore();
		int numberOfQuestions = InitQuizzler.getActiveQuiz().getQuestionsInt();
		scoreResults.setText(score + "/" + numberOfQuestions);
	}
}

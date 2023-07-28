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

/**
 * FXML Controller class for viewHighscores.fxml
 */
public class ViewHighscoresController implements Initializable {
	// Views
	@FXML
	private ListView<String> scoreListView;

	private ArrayList<Attempt> attemptList;

	/**
	 * Switches to the menu view.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void switchToMenu() throws IOException {
		InitQuizzler.setRoot("menu");
	}

	/**
	 * Gets the attempts from the server and adds them to a list.
	 */
	private void getItem() {
		try {
			Connection connection = InitQuizzler.getConnection();
			attemptList = connection.getQuizFromServer(InitQuizzler.getActiveQuiz().getName()).getAttempts();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the view. Gets all the scores from the server and displays them
	 * in a listview.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		getItem();
		List<String> highscoreList = new ArrayList<>();
		for (Attempt attempt : attemptList) {
			highscoreList.add(attempt.getUsername()
					+ ": "
					+ attempt.getScore()
					+ "/"
					+ InitQuizzler.getActiveQuiz().getQuestionsInt());
		}
		scoreListView.setItems(FXCollections.observableList(highscoreList));
	}
}

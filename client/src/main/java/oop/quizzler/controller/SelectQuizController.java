package oop.quizzler.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import oop.quizzler.model.Connection;

/**
 * FXML Controller class for selectQuiz.fxml
 */
public class SelectQuizController implements Initializable {
	// Views
	@FXML
	private ListView<String> quizListView;

	private List<String> quizList;

	private Connection connection;

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
	 * Switches to the enterUsername view. Sets the active quiz to the selected
	 * quiz.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void switchToEnterUsername() throws IOException {
		InitQuizzler.setActiveQuiz(connection.getQuizFromServer(quizListView.getSelectionModel().getSelectedItem()));
		InitQuizzler.setRoot("enterUsername");
	}

	/**
	 * Deletes the selected quiz from the server. (with confirmation)
	 */
	@FXML
	private void deleteQuiz() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Delete Quiz");
		alert.setHeaderText("Are you sure you want to delete this quiz?");
		if (alert.showAndWait().get().getText().equals("OK")) {
			connection.deleteQuizFromServer(quizListView.getSelectionModel().getSelectedItem());
			getItem();
			quizListView.setItems(FXCollections.observableList(quizList));
			alert.close();
		} else {
			alert.close();
		}
	}

	/**
	 * Gets all the quiznames from the server and displays them in a listview.
	 */
	@FXML
	private void getItem() {
		connection = InitQuizzler.getConnection();
		quizList = Arrays.asList(connection.getAllQuizNamesFromServer());
	}

	/**
	 * Initializes the view. Gets all the quiznames from the server and displays
	 * them in a listview.
	 * 
	 * @param url not used but required
	 * @param rb  not used but required
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		getItem();
		quizListView.setItems(FXCollections.observableList(quizList));
	}
}

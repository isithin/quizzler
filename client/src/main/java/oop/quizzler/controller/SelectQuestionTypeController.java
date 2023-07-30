package oop.quizzler.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import oop.quizzler.model.Connection;
import oop.quizzler.model.DisplayType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class for selectQuestionType.fxml
 */
public class SelectQuestionTypeController {

	// Views
	@FXML
	private RadioButton mc;

	@FXML
	private RadioButton tf;

	@FXML
	private RadioButton sc;

	@FXML
	private ToggleGroup group;

	/**
	 * Switches to the enterQuestion view. Sets the displayType to the selected
	 * type. If no type is selected, it will show an alert.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void switchToEnterQuestion() throws IOException {
		RadioButton selected = (RadioButton) group.getSelectedToggle();
		if (selected != null) {
			if (selected.getId().equals(mc.getId())) {
				InitQuizzler.setDisplayType(DisplayType.MC);
			}
			if (selected.getId().equals(tf.getId())) {
				InitQuizzler.setDisplayType(DisplayType.TF);
			}
			if (selected.getId().equals(sc.getId())) {
				InitQuizzler.setDisplayType(DisplayType.SC);
			}
			InitQuizzler.setRoot("enterQuestion");
		} else {
			alerting("Please select a Questiontype");
		}
	}

	/**
	 * adds the quiz to the server. If no questions were added to the quiz, it will
	 * show an alert. If the quiz was added successfully, it will show an alert and
	 * switch to the menu view. If the quiz was not added successfully, it will show
	 * an alert.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void saveAndQuit() throws IOException {
		if (InitQuizzler.getNewQuiz().getQuestionsInt() == 0) {
			alerting("Please add at least one question");
		} else {
			Connection connection = InitQuizzler.getConnection();
			if (connection.addQuizToServer(InitQuizzler.getNewQuiz())) {
				Alert alert = new Alert(AlertType.NONE, "Quiz added", ButtonType.OK);
				alert.showAndWait();

				if (alert.getResult().equals(ButtonType.OK)) {
					alert.close();
					InitQuizzler.setRoot("menu");
				}
			} else {
				alerting("Error: Quiz not added");
			}
		}
	}

	/**
	 * Switches to the menu view.
	 * 
	 * @throws IOException if the view cannot be found
	 */
	@FXML
	private void quit() throws IOException {
		InitQuizzler.setRoot("menu");
	}

	/**
	 * Here to avoid code duplication. Shows an alert with the given message.
	 * 
	 * @param message the message to be shown
	 */
	public void alerting(String message) {
		Alert alert = new Alert(AlertType.NONE, message, ButtonType.OK);
		alert.showAndWait();
		if (alert.getResult().equals(ButtonType.OK)) {
			alert.close();
		}
	}
}

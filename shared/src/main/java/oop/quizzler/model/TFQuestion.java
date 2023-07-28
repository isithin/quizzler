package oop.quizzler.model;

import java.util.ArrayList;

/**
 * Class that represents a text field question. (extends Question)
 */
public class TFQuestion extends Question {
	/**
	 * @param question
	 * @param correctAnswers constructor that automatically sets the display type to
	 *                       TF
	 */
	public TFQuestion(String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
		this.displayType = DisplayType.TF;
	}

	/**
	 * @param givenAnswers
	 * @return checks if the given answer is correct. (Specifically for TF
	 *         questions)
	 */
	@Override
	public boolean checkAnswer(ArrayList<String> givenAnswers) {
		if (givenAnswers.size() != this.correctAnswers.size()) {
			return false;
		}
		for (String answer : givenAnswers) {
			if (!this.correctAnswers.contains(answer)) {
				return false;
			}
		}
		return true;
	}
}

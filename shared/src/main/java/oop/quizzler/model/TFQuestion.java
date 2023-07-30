package oop.quizzler.model;

import java.util.ArrayList;

/**
 * Class that represents a text field question. (extends Question)
 */
public class TFQuestion extends Question {
	/**
	 * constructor that automatically sets the display type to TF
	 * 
	 * @param question       question to be asked
	 * @param correctAnswers correct answers to the question
	 */
	public TFQuestion(String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
		this.displayType = DisplayType.TF;
	}

	/**
	 * checks if the given answer is correct. (Specifically for TF questions)
	 * 
	 * @param givenAnswers answers given by the user
	 * @return returns true if the given answer is correct, false if not
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

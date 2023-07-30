package oop.quizzler.model;

import java.util.ArrayList;

/**
 * Class that represents a single choice question. (extends Question)
 */
public class SCQuestion extends Question {
	private String[] answers;

	/**
	 * constructor that automatically sets the display type to SC
	 * 
	 * @param question       question to be asked
	 * @param correctAnswers correct answers to the question
	 */
	public SCQuestion(String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
		this.displayType = DisplayType.SC;
	}

	/**
	 * @return returns the answers in the form of a string array
	 */
	public String[] getAnswers() {
		return this.answers;
	}

	/**
	 * checks if the given answer is correct. (Specifically for SC questions)
	 * 
	 * @param givenAnswers answers given by the user
	 * @return returns true if the given answer is correct, false if not
	 */
	@Override
	public boolean checkAnswer(ArrayList<String> givenAnswers) {
		if (!this.correctAnswers.contains(givenAnswers.get(0))) {
			return false;
		}
		return true;
	}
}

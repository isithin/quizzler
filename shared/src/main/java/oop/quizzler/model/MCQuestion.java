package oop.quizzler.model;

import java.util.ArrayList;

/**
 * Class that represents a multiple choice question. (extends Question)
 */
public class MCQuestion extends Question {
	private String[] answers;

	/**
	 * constructor that automatically sets the display type to MC
	 * 
	 * @param question       question to be asked
	 * @param answers        answers to the question
	 * @param correctAnswers correct answers to the question
	 */
	public MCQuestion(String question, String[] answers, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
		this.displayType = DisplayType.MC;
		this.answers = answers;
	}

	/**
	 * @return returns the answers in the form of a string array
	 */
	public String[] getAnswers() {
		return this.answers;
	}

	/**
	 * checks if the given answers are correct. (Specifically for MC questions)
	 * 
	 * @param givenAnswers answers given by the user
	 * @return returns true if the given answers are correct, false if not
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

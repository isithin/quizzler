package oop.quizzler.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that represents a question. (abstract)
 */
public abstract class Question implements Serializable {
	/**
	 * The question.
	 */
	protected String question;

	/**
	 * The correct answers.
	 */
	protected ArrayList<String> correctAnswers;

	/**
	 * The display type.
	 */
	protected DisplayType displayType;

	/**
	 * constructor that sets the question and the correct answers (display type is
	 * set in the extending classes)
	 * 
	 * @param question       question to be asked
	 * @param correctAnswers correct answers to the question
	 */
	public Question(String question, ArrayList<String> correctAnswers) {
		this.question = question;
		this.correctAnswers = correctAnswers;
	}

	/**
	 * @return returns the question
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * @return returns the correct answers in the form of an array list of strings
	 */
	public ArrayList<String> getCorrectAnswer() {
		return this.correctAnswers;
	}

	/**
	 * @return returns the display type of the question
	 */
	public DisplayType getDisplayType() {
		return this.displayType;
	}

	/**
	 * abstract method to check if the given answers are correct. (implemented in
	 * the extending classes)
	 * 
	 * @param givenAnswers answers given by the user
	 * @return returns true if the given answers are correct, false if not
	 */
	public abstract boolean checkAnswer(ArrayList<String> givenAnswers);
}

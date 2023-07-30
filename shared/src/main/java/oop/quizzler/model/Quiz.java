package oop.quizzler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represents a quiz.
 */
public class Quiz implements Serializable {
	private String name;

	private ArrayList<Question> questions = new ArrayList<>();

	private ArrayList<Attempt> scores = new ArrayList<>();

	/**
	 * constructor that sets the name of the quiz
	 * 
	 * @param name name of the quiz
	 */
	public Quiz(String name) {
		this.name = name;
	}

	/**
	 * @return returns the name of the quiz
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * adds a question to the array list of questions
	 * 
	 * @param question question to be added
	 */
	public void setQuestion(Question question) {
		this.questions.add(question);
	}

	/**
	 * @return returns the questions of the quiz in the form of an array list of
	 *         questions
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}

	/**
	 * @return returns the number of questions in the quiz
	 */
	public int getQuestionsInt() {
		return this.questions.size();
	}

	/**
	 * adds an attempt to the scores of the quiz sorts the scores from high to low
	 * using Collections
	 * 
	 * @param attempt attempt to be added
	 */
	public void setAttempt(Attempt attempt) {
		this.scores.add(attempt);
		Collections.sort(scores);
	}

	/**
	 * @return returns the attempts of the quiz in the form of an array list of
	 *         attempts
	 */
	public ArrayList<Attempt> getAttempts() {
		return scores;
	}
}

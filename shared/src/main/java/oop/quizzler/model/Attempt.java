package oop.quizzler.model;

import java.io.Serializable;

/**
 * Class that represents an attempt at a quiz by a user.
 */
public class Attempt implements Comparable<Object>, Serializable {
	private String username;

	private int score;

	private Quiz activeQuiz;

	private int count = 0;

	/**
	 * Constructor for Attempt.
	 * 
	 * @param username   username of the user who attempted the quiz
	 * @param activeQuiz the active quiz
	 */
	public Attempt(String username, Quiz activeQuiz) {
		this.username = username;
		this.activeQuiz = activeQuiz;
	}

	/**
	 * Compares the score of this attempt to another attempt.
	 * 
	 * @param other the other attempt to compare to
	 * @return Returns the difference between the scores of the attempts.
	 */
	@Override
	public int compareTo(Object other) {
		Attempt otherAttempt = (Attempt) other;
		return otherAttempt.getScore() - this.getScore();
	}

	/**
	 * @return Returns the username of the user who attempted the quiz.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user who attempted the quiz.
	 * 
	 * @param username The username of the user who attempted the quiz.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return Returns the score of the attempt.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score of the attempt.
	 * 
	 * @param score The score of the attempt.
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return Returns the count of the current number of questions answered.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count to the current number of questions answered.
	 * 
	 * @param newCount The current number of questions answered.
	 */
	public void setCount(int newCount) {
		this.count = newCount;
	}

	/**
	 * @return Returns the active quiz.
	 */
	public Quiz getActiveQuiz() {
		return activeQuiz;
	}

	/**
	 * Sets the active quiz to the quiz specified in the parameter.
	 * 
	 * @param activeQuiz The active quiz.
	 */
	public void setActiveQuiz(Quiz activeQuiz) {
		this.activeQuiz = activeQuiz;
	}
}

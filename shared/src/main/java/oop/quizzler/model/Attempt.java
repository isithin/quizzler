package oop.quizzler.model;

import java.io.Serializable;
/**
 * Class that represents an attempt at a quiz by a user.
 */
public class Attempt implements Comparable<Object>, Serializable{
    private String username;
    private int score;
    private Quiz activeQuiz;
    private int count = 0;

    /**
     * @param username
     * @param activeQuiz
     * Constructor for Attempt.
     */
    public Attempt(String username, Quiz activeQuiz) {
        this.username = username;
        this.activeQuiz = activeQuiz;
    }

    /**
     * @param other
     * @return 
     * Compares the score of this attempt to another attempt.
     */
    @Override
    public int compareTo(Object other) {
        Attempt otherAttempt = (Attempt) other;
        return otherAttempt.getScore() - this.getScore();
    }

    /**
     * @return
     * Returns the username of the user who attempted the quiz.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     * Sets the username of the user who attempted the quiz.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     * Returns the score of the attempt.
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score
     * Sets the score of the attempt.
     */
    public void setScore(int score) {
        this.score = score;
    }  

    /**
     * @return
     * Returns the count of the current number of questions answered.
     */
    public int getCount() {
        return count;
    }

    /**
     * @param newCount
     * Sets the count to the current number of questions answered.
     */
    public void setCount(int newCount) {
        this.count = newCount;
    }

    /**
     * @return
     * Returns the active quiz.
     */
    public Quiz getActiveQuiz() {
        return activeQuiz;
    }

    /**
     * @param activeQuiz
     * Sets the active quiz to the quiz specified in the parameter.
     */
    public void setActiveQuiz(Quiz activeQuiz) {
        this.activeQuiz = activeQuiz;
    }


}

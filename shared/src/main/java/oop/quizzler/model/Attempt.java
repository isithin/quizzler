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
     */
    public Attempt(String username, Quiz activeQuiz) {
        this.username = username;
        this.activeQuiz = activeQuiz;
    }

    /**
     * @param other
     * @return 
     */
    @Override
    public int compareTo(Object other) {
        Attempt otherAttempt = (Attempt) other;
        return otherAttempt.getScore() - this.getScore();
    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }  

    /**
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * @param newCount
     */
    public void setCount(int newCount) {
        this.count = newCount;
    }

    /**
     * @return
     */
    public Quiz getActiveQuiz() {
        return activeQuiz;
    }

    /**
     * @param activeQuiz
     */
    public void setActiveQuiz(Quiz activeQuiz) {
        this.activeQuiz = activeQuiz;
    }


}

package oop.quizzler.model;

import java.io.Serializable;

public class Attempt implements Comparable, Serializable{
    private String username;
    private int score;
    private Quiz activeQuiz;
    private int count = 0;

    public Attempt(String username, Quiz activeQuiz) {
        this.username = username;
        this.activeQuiz = activeQuiz;
    }

    public int compareTo(Object other) {
        Attempt otherAttempt = (Attempt) other;
        return otherAttempt.getScore() - this.getScore();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }  

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) {
        this.count = newCount;
    }


}

package oop.quizzler.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable{
    private String question;
    private String[] answers;
    private ArrayList<String> correctAnswers;

    public Question (String question, String[] answers, ArrayList<String> correctAnswers) {
		this.question = question; 
		this.answers = answers;
		this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public ArrayList<String>getCorrectAnswer() {
        return this.correctAnswers;
    }

}


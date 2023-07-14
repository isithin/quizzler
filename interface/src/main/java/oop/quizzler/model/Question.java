package oop.quizzler.model;

import java.io.Serializable;

public class Question implements Serializable{
    private String question;
    private String[] answers;
    private String correctAnswer;

    public Question (String question, String[] answers, String correctAnswer) {
		this.question = question; 
		this.answers = answers;
		this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

}


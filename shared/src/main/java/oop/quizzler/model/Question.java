package oop.quizzler.model;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable{
    protected String question;
    protected ArrayList<String> correctAnswers;
    protected DisplayType displayType;

    public Question (String question, ArrayList<String> correctAnswers) {
		this.question = question; 
		this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return this.question;
    }

    public ArrayList<String>getCorrectAnswer() {
        return this.correctAnswers;
    }

    public DisplayType getDisplayType() {
        return this.displayType;
    }

    public abstract boolean checkAnswer(ArrayList<String> givenAnswers);

}


package oop.quizzler.model;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable{
    protected String question;
    protected String[] answers;
    protected ArrayList<String> correctAnswers;
    protected boolean isCorrect;
    protected DisplayType displayType;

    
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

    public boolean getIsCorrect() {
        return this.isCorrect;
    }
    
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public DisplayType getDisplayType() {
        return this.displayType;
    }

    public abstract void checkAnswer(ArrayList<String> givenAnswers);

}


package oop.quizzler.model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that represents a question. (abstract)
 */
public abstract class Question implements Serializable{
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
     * @param question
     * @param correctAnswers
     * constructor that sets the question and the correct answers
     * (display type is set in the extending classes)
     */
    public Question (String question, ArrayList<String> correctAnswers) {
		this.question = question; 
		this.correctAnswers = correctAnswers;
    }

    /**
     * @return
     * returns the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * @return
     * returns the correct answers in the form of an array list of strings
     */
    public ArrayList<String>getCorrectAnswer() {
        return this.correctAnswers;
    }

    /**
     * @return
     * returns the display type of the question
     */
    public DisplayType getDisplayType() {
        return this.displayType;
    }

    /**
     * @param givenAnswers
     * @return
     * abstract method to check if the given answers are correct. 
     * Implemented in all extending classes.
     */
    public abstract boolean checkAnswer(ArrayList<String> givenAnswers);

}


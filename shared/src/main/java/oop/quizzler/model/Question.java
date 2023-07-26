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
     */
    public Question (String question, ArrayList<String> correctAnswers) {
		this.question = question; 
		this.correctAnswers = correctAnswers;
    }

    /**
     * @return
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * @return
     */
    public ArrayList<String>getCorrectAnswer() {
        return this.correctAnswers;
    }

    /**
     * @return
     */
    public DisplayType getDisplayType() {
        return this.displayType;
    }

    /**
     * @param givenAnswers
     * @return
     * abstract method to check if the given answers are correct
     */
    public abstract boolean checkAnswer(ArrayList<String> givenAnswers);

}


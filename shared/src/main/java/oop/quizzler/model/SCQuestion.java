package oop.quizzler.model;

import java.util.ArrayList;

/**
 * Class that represents a single choice question. (extends Question)
 */
public class SCQuestion extends Question{
    private String[] answers;

    /**
     * @param question
     * @param correctAnswers
     * constructor that automatically sets the display type to SC
     */
    public SCQuestion (String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
        this.displayType = DisplayType.SC;
	}

    /**
     * @return
     * returns the answers in the form of a string array
     */
    public String[] getAnswers() {
        return this.answers;
    }

    /**
     * @param givenAnswers
     * @return
     * checks if the given answer is correct. (Specifically for SC questions)
     */
    @Override
    public boolean checkAnswer(ArrayList<String> givenAnswers) {
        if (!this.correctAnswers.contains(givenAnswers.get(0))) {
            return false;
        }
        return true;
    }
}




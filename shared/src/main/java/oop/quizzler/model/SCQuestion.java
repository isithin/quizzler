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
     */
    public SCQuestion (String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
        this.displayType = DisplayType.SC;
	}

    /**
     * @return
     */
    public String[] getAnswers() {
        return this.answers;
    }

    /**
     * @param givenAnswers
     * @return
     * checks if the given answer is correct 
     */
    @Override
    public boolean checkAnswer(ArrayList<String> givenAnswers) {
        if (!this.correctAnswers.contains(givenAnswers.get(0))) {
            return false;
        }
        return true;
    }
}




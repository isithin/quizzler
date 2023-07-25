package oop.quizzler.model;

import java.util.ArrayList;

public class SCQuestion extends Question{
    private String[] answers;

    public SCQuestion (String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
        this.displayType = DisplayType.SC;
	}

    public String[] getAnswers() {
        return this.answers;
    }

    @Override
    public boolean checkAnswer(ArrayList<String> givenAnswers) {
        if (!this.correctAnswers.contains(givenAnswers.get(0))) {
            return false;
        }
        return true;
    }
}




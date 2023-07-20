package oop.quizzler.model;
import java.util.ArrayList;

public class MCQuestion extends Question{

    public MCQuestion (String question, String[] answers, ArrayList<String> correctAnswers) {
		super(question, answers, correctAnswers);
        this.displayType = DisplayType.MC;
	}

    @Override
    public void checkAnswer(ArrayList<String> givenAnswers) {
        if (givenAnswers.size() != this.correctAnswers.size()) {
            this.isCorrect = false;
            return;
        }
        for (String answer : givenAnswers) {
            if (!this.correctAnswers.contains(answer)) {
                this.isCorrect = false;
                return;
            }
        }
        this.isCorrect = true;
    }


}


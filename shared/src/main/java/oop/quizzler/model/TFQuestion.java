package oop.quizzler.model;
import java.util.ArrayList;

public class TFQuestion extends Question{

    public TFQuestion (String question, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
        this.displayType = DisplayType.TF;
	}

    @Override
    public boolean checkAnswer(ArrayList<String> givenAnswers) {
        if (givenAnswers.size() != this.correctAnswers.size()) {
            return false;
        }
        for (String answer : givenAnswers) {
            if (!this.correctAnswers.contains(answer)) {
                return false;
            }
        }
        return true;
    }


}
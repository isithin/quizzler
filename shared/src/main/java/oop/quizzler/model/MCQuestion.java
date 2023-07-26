package oop.quizzler.model;
import java.util.ArrayList;

/**
 * Class that represents a multiple choice question. (extends Question)
 */
public class MCQuestion extends Question{
    private String[] answers;

    /**
     * @param question
     * @param answers
     * @param correctAnswers
     */
    public MCQuestion (String question, String[] answers, ArrayList<String> correctAnswers) {
		super(question, correctAnswers);
        this.displayType = DisplayType.MC;
        this.answers = answers;
	}

    /**
     * @return
     */
    public String[] getAnswers() {
        return this.answers;
    }

    /**
     * @param answers
     * @return
     * checks if the given answers are correct
     */
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


package Beans;

import java.io.Serializable;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Guessing game bean is the back end to the guessing game. this class evaluates
 * a users input and compares it to the system generated random number it
 * assigns a score dependent on how close the user input is to system generated
 * number
 *
 * @author Ande404
 */
@Named(value = "guessingGameBean")
@RequestScoped
public class GuessingGameBean implements Serializable {

    private Random random = new Random();
    private final int RANGE = 10;
    private int userGuess;
    private int score;
    private int answer = 0;

    /**
     * Creates a new instance of GuessingGameBean
     */
    public GuessingGameBean() {

    }

    public void evaluate() {
        setScore(evaluate(getUserGuess(), getAnswer()));
    }

    private int evaluate(int nums, int answer) {
        if (nums == answer) {
            return 5;
        } else if (Math.abs(answer - nums) == 1) {
            return 2;
        } else if (Math.abs(answer - nums) == 2) {
            return 1;
        }

        return -2;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;

        //generate random number
        int randomNumber = random.nextInt(RANGE) + 1;

        //setAnser to random number
        setAnswer(randomNumber);

        evaluate();
    }

    public int getUserGuess() {
        return userGuess;
    }

    public int getScore() {
        return score;
    }

    public int getAnswer() {
        return answer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}

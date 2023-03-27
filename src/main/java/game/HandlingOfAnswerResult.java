package game;

import java.sql.SQLException;

public class HandlingOfAnswerResult {
    public void win() {
        // print out congratulation message
        System.out.println("\u001B[33m" + "Congratulations! You have just become a millionaire!" + "\u001B[0m");
        // terminate game
        System.exit(0);
    }

    public void handleCorrectAnswer(GameSession gS, Question question) throws SQLException {
        // update the player's score
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Congratulations! You have answered this question correctly. Your current score is " + gS.getScore() + " points." + "\u001B[0m");
        // if the score of 30 points is reached, player becomes a millionaire
        if (gS.getScore() == 30) {
            win();
        }
    }

    public void handleIncorrectAnswer(GameSession gS) throws SQLException {
        gS.setScore(0);
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[31m" + "Unfortunately you have answered incorrectly. You may wish to try the game once again!" + "\u001B[0m");
        // terminate game
        System.exit(0);
    }
}

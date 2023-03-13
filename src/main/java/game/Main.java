package game;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void play(GameSession gS) throws SQLException {
        gS.setScore(0);
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        for (int i = 0; i<QuestionsBank.questions().size(); i++) {
            Random rand = new Random();
            int r = rand.nextInt(3);
            Question question = QuestionsBank.questions().get(i)[r];
            AnsweringQuestion.displayAndAnswerQuestion(gS, question, question.getLevel());
        }
    }

    public static void main(String[] args) throws SQLException, InputMismatchException {
        GameSession gS = new GameSession();
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        String y_n = Scan.scanString();
        if (y_n.equals("Yes")) {
            Authentication.logIn(gS);
            play(gS);
        } else if (y_n.equals("No")) {
            Authentication.signUp(gS);
            play(gS);
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
    }
}

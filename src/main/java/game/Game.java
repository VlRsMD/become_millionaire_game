package game;

import java.sql.SQLException;
import java.util.*;

public class Game {
    public void play(GameSession gS) throws SQLException {
        gS.setScore(0);
        Random rand = new Random();
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        QuestionsBank questionsBank = new QuestionsBank();
        for (int i = 0; i<questionsBank.getNumberOfLevels(); i++) {
            int r = rand.nextInt(3);
            List<Question> levelQuestions = new ArrayList<Question>();
            for (int k = 0; k<questionsBank.createQuestions().size(); k++) {
                int levelIndex = i+1;
                if (questionsBank.createQuestions().get(k).getLevel() == levelIndex) {
                    levelQuestions.add(questionsBank.createQuestions().get(k));
                }
            }
            Question question = levelQuestions.get(r);
            AnsweringQuestionHandling answeringQuestionHandling = new AnsweringQuestionHandling();
            answeringQuestionHandling.displayAndAnswerQuestion(gS, question, question.getLevel());
        }
    }

    public void startGame(GameSession gS) throws SQLException {
        Authentication authentication = new Authentication();
        StringScanner scanner = new StringScanner();
        String y_n = scanner.scanString();
        if (y_n.equals("Yes")) {
            System.out.println("Introduce your username: ");
            authentication.logIn(gS);
            play(gS);
        } else if (y_n.equals("No")) {
            System.out.println("Please create an account by introducing your username: ");
            authentication.signUp(gS);
            play(gS);
        } else {
            System.out.println("Invalid input. Try again: ");
            startGame(gS);
        }
    }

    // static
    public static void main(String[] args) throws SQLException, InputMismatchException {
        Game game = new Game();
        GameSession gS = new GameSession();
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        game.startGame(gS);
    }
}

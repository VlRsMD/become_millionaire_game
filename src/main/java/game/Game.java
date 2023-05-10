package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Game {
    public void play(GameSession gS) throws SQLException, IOException {
        gS.setScore(0);
        Random rand = new Random();
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        List<Question> questionsList = gS.getQuestionsBank().getAllQuestions();
        for (int i = 0; i < gS.getQuestionsBank().getNumberOfLevels(); i ++) {
            int r = rand.nextInt(3);
            List<Question> levelQuestions = new ArrayList<Question>();
            for (Question question : questionsList) {
                int levelIndex = i + 1;
                if (question.getLevel() == levelIndex) {
                    levelQuestions.add(question);
                }
            }
            Question currentQuestion = levelQuestions.get(r);
            HandlingOfAnsweringQuestion answeringQuestionHandling = new HandlingOfAnsweringQuestion();
            answeringQuestionHandling.displayAndAnswerQuestion(gS, currentQuestion, currentQuestion.getLevel());
        }
    }

    public void startGame(GameSession gS) throws SQLException, IOException {
        Authentication authentication = new Authentication();
        StringScanner scanner = new StringScanner();
        String loggedInStatus = scanner.scanString();
        if ("Yes".equals(loggedInStatus)) {
            System.out.println("Introduce your username: ");
            authentication.logIn(gS);
            play(gS);
        } else if ("No".equals(loggedInStatus)) {
            System.out.println("Please create an account by introducing your username: ");
            authentication.signUp(gS);
            play(gS);
        } else {
            System.out.println("Invalid input. Try again: ");
            startGame(gS);
        }
    }
}

package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Game {
    public void play(GameSession gS) throws SQLException, IOException {
        gS.setScore(0);
        Random rand = new Random();
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        QuestionsBank questionsBank = new QuestionsBank();
        List<Question> questionsList = questionsBank.getAllQuestions();
        FiftyFiftyHelpOption fiftyFiftyHelpOption = new FiftyFiftyHelpOption();
        AskAudienceHelpOption askAudienceHelpOption = new AskAudienceHelpOption();
        PhoneFriendHelpOption phoneFriendHelpOption = new PhoneFriendHelpOption();
        for (int i = 0; i < questionsBank.getNumberOfLevels(); i ++) {
            int r = rand.nextInt(3);
            List<Question> levelQuestions = new ArrayList<Question>();
            for (Question value : questionsList) {
                int levelIndex = i + 1;
                if (value.getLevel() == levelIndex) {
                    levelQuestions.add(value);
                }
            }
            Question question = levelQuestions.get(r);
            HandlingOfAnsweringQuestion answeringQuestionHandling = new HandlingOfAnsweringQuestion();
            answeringQuestionHandling.displayAndAnswerQuestion(gS, question, question.getLevel(), fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
        }
    }

    public void startGame(GameSession gS) throws SQLException, IOException {
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
    public static void main(String[] args) throws SQLException, InputMismatchException, IOException {
        Game game = new Game();
        GameSession gS = new GameSession();
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        game.startGame(gS);
    }
}

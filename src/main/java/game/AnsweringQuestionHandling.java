package game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class AnsweringQuestionHandling {
    public void displayAndAnswerQuestion(GameSession gS, Question question, int level) throws SQLException {
        // print out the level of current question and the question itself
        System.out.println("Level " + level + " question: " + question.getQuestion());
        List<Answer> answersList = new ArrayList<Answer>();
        for (int i = 0; i < question.getAnswersOptions().length; i++) {
            answersList.add(question.getAnswersOptions()[i]);
        }
        Collections.shuffle(answersList);
        // print out answer options
        for (int j = 0; j < answersList.size(); j++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + answersList.get(j).getAnswer());
        }
        answerQuestion(gS, question, answersList);
    }

    public void chooseAnswerOption(GameSession gS, Question question, List<Answer> answersList) throws SQLException {
        Help help = new Help();
        AnswerResultHandling answerResultHandling = new AnswerResultHandling();
        StringScanner scanner = new StringScanner();
        String id = scanner.scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (answersList.get(Integer.parseInt(id)-1).isCorrect() == true) {
                answerResultHandling.handleCorrectAnswer(gS, question);
            }
            // in case the answer introduced is incorrect
            else {
                answerResultHandling.handleIncorrectAnswer(gS);
            }
        } else if (id.equals("a") && Help.askAudienceUsage == 0) {
            help.askAudience(gS, question, answersList);
        } else if (id.equals("p") && Help.phoneFriendUsage == 0) {
            help.phoneFriend(gS, question, answersList);
        } else if (id.equals("f") && Help.fiftyFiftyUsage == 0) {
            help.displayFiftyFifty(gS, question, answersList);
        } else {
            System.out.println("Invalid input. Try again: ");
            chooseAnswerOption(gS, question, answersList);
        }
    }

    public void answerQuestion(GameSession gS, Question question, List<Answer> answersList) throws SQLException, InputMismatchException {
        AnswerResultHandling answerResultHandling = new AnswerResultHandling();
        if (Help.askAudienceUsage == 0 && Help.phoneFriendUsage == 0 && Help.fiftyFiftyUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.");
        }
        if (Help.askAudienceUsage != 0 && Help.phoneFriendUsage == 0 && Help.fiftyFiftyUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once each of the following help options: 'Phone a Friend', '50/50'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.");
        }
        if (Help.phoneFriendUsage != 0 && Help.askAudienceUsage == 0 && Help.fiftyFiftyUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once each of the following help options: 'Ask the Audience', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the '50/50' option type 'f'.");
        }
        if (Help.fiftyFiftyUsage != 0 && Help.phoneFriendUsage == 0 && Help.askAudienceUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'.");
        }
        if (Help.askAudienceUsage != 0 && Help.phoneFriendUsage != 0 && Help.fiftyFiftyUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use the following help option: '50/50'. In order to choose the '50/50' option type 'f'.");
        }
        if (Help.fiftyFiftyUsage != 0 && Help.phoneFriendUsage != 0 && Help.askAudienceUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use the following help option: 'Ask the Audience'. In order to choose the 'Ask the Audience' option type 'a'.");
        }
        if (Help.askAudienceUsage != 0 && Help.fiftyFiftyUsage != 0 && Help.phoneFriendUsage == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use the following help option: 'Phone a Friend'. In order to choose the 'Phone a Friend' option type 'p'.");
        }
        if (Help.askAudienceUsage != 0 && Help.phoneFriendUsage != 0 && Help.fiftyFiftyUsage != 0) {
            System.out.println("Introduce the number of the correct answer: ");
        }
        chooseAnswerOption(gS, question, answersList);
    }
}

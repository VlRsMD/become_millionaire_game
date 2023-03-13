package game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class AnsweringQuestion {
    public static void displayAndAnswerQuestion(GameSession gS, Question question, int level) throws SQLException {
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

    public static void answerQuestion(GameSession gS, Question question, List<Answer> answersList) throws SQLException, InputMismatchException {
        if (Help.useHelp == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once one of the following help options: 'Ask the Audience', 'Phone a Friend', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.");
            String id = Scan.scanString();
            if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
                // in case the answer introduced is correct
                if (answersList.get(Integer.parseInt(id)-1).isCorrectness() == true) {
                    QuestionAnswered.correctAnswer(gS, question);
                }
                // in case the answer introduced is incorrect
                else {
                    QuestionAnswered.incorrectAnswer(gS);
                }
            } else if (id.equals("a")) {
                Help.askAudience(gS, question, answersList);
            } else if (id.equals("p")) {
                Help.phoneFriend(gS, question, answersList);
            } else if (id.equals("f")) {
                Help.fiftyFifty(gS, question, answersList);
            } else {
                System.out.println("Invalid input.");
                System.exit(0);
            }
        } else {
            System.out.println("Introduce the number of the correct answer: ");
            String id = Scan.scanString();
            if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
                // in case the answer introduced is correct
                if (answersList.get(Integer.parseInt(id)-1).isCorrectness() == true) {
                    QuestionAnswered.correctAnswer(gS, question);
                }
                // in case the answer introduced is incorrect
                else {
                    QuestionAnswered.incorrectAnswer(gS);
                }
            } else {
                System.out.println("Invalid input.");
                System.exit(0);
            }
        }
    }
}

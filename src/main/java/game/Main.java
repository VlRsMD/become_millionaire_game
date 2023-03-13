package game;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void answerQuestion(GameSession gS, Question question, int level) throws InterruptedException, SQLException, InputMismatchException {
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

    public static void play(GameSession gS) throws SQLException, InterruptedException {
        gS.setScore(0);
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        for (int i = 0; i<QuestionsBank.questions().size(); i++) {
            Random rand = new Random();
            int r = rand.nextInt(3);
            Question question = QuestionsBank.questions().get(i)[r];
            answerQuestion(gS, question, question.getLevel());
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException, InputMismatchException {
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

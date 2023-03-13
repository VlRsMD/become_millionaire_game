package game;

import java.sql.SQLException;
import java.util.*;

public class Help {
    public static int useHelp;

    public static void phoneFriend (GameSession gS, Question question, List<Answer> list) throws SQLException {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrectness() == true) {
                int id = i+1;
                System.out.println("\u001B[34m" + "The right answer is nr. " + id + ": " + list.get(i).getAnswer()+"."  + "\u001B[0m");
                break;
            }
        }
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Your current score is " + gS.getScore() + " points." + "\u001B[0m");
        useHelp ++;
    }

    public static void askAudience (GameSession gS, Question question, List<Answer> list) throws SQLException, InterruptedException, InputMismatchException {
        for(int i=0; i<list.size(); i++) {
            int id = i+1;
            System.out.println("\u001B[34m" + id + ". " + list.get(i).getAnswer() + " - " + list.get(i).getDistributionPercentage()+"%" + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        String id = Scan.scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (list.get(Integer.parseInt(id) - 1).isCorrectness() == true) {
                QuestionAnswered.correctAnswer(gS, question);
            } else {
                QuestionAnswered.incorrectAnswer(gS);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
        useHelp ++;
    }

    public static void fiftyFifty (GameSession gS, Question question, List<Answer> list) throws SQLException, InterruptedException, InputMismatchException {
        int rightAnswerIndex = 0;
        int wrongAnswerIndex = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrectness() == true) {
                rightAnswerIndex = i;
                break;
            }
        }
        List<Answer> wrongAnswersList = new ArrayList<Answer>();
        for (int i=0; i<list.size(); i++) {
            if(list.get(i).isCorrectness() == false) {
                wrongAnswersList.add(list.get(i));
            }
        }
        Random rand = new Random();
        int r = rand.nextInt(3);
        Answer wrongAnswer = wrongAnswersList.get(r);
        for (int i=0; i<= list.size(); i++) {
            if(list.get(i).getAnswer() == wrongAnswer.getAnswer()) {
                wrongAnswerIndex = i;
                break;
            }
        }
        int rightAnswerID = rightAnswerIndex+1;
        int wrongAnswerID = wrongAnswerIndex+1;
        List<List<String>> twoOptions = new ArrayList<List<String>>();
        List<String> rightOption = new ArrayList<String>();
        rightOption.add(String.valueOf(rightAnswerID));
        rightOption.add(list.get(rightAnswerIndex).getAnswer());
        List<String> wrongOption = new ArrayList<String>();
        wrongOption.add(String.valueOf(wrongAnswerID));
        wrongOption.add(list.get(wrongAnswerIndex).getAnswer());
        twoOptions.add(rightOption);
        twoOptions.add(wrongOption);
        Collections.shuffle(twoOptions);
        for (int i=0; i<twoOptions.size(); i++) {
            System.out.println("\u001B[34m" + twoOptions.get(i).get(0) + ". " + twoOptions.get(i).get(1) + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        String id = Scan.scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (list.get(Integer.parseInt(id) - 1).isCorrectness() == true) {
                QuestionAnswered.correctAnswer(gS, question);
            } else {
                QuestionAnswered.incorrectAnswer(gS);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
        useHelp ++;
    }
}

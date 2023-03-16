package game;

import java.sql.SQLException;
import java.util.*;

public class Help {
    public static int askAudienceUsage;
    public static int phoneFriendUsage;
    public static int fiftyFiftyUsage;

    public void phoneFriend (GameSession gS, Question question, List<Answer> list) throws SQLException {
        phoneFriendUsage ++;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrect() == true) {
                int id = i+1;
                System.out.println("\u001B[34m" + "The right answer is nr. " + id + ": " + list.get(i).getAnswer()+"."  + "\u001B[0m");
                break;
            }
        }
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Your current score is " + gS.getScore() + " points." + "\u001B[0m");
    }

    public void askAudience (GameSession gS, Question question, List<Answer> list) throws SQLException, InputMismatchException {
        askAudienceUsage ++;
        Random rand = new Random();
        List<List<String>> distributionList = new ArrayList<List<String>>();
        for(int k=0; k<list.size(); k++) {
            List<String> distribution = new ArrayList<String>();
            distribution.add(list.get(k).getAnswer());
            if (list.get(k).isCorrect() == true) {
                int r = 31 + rand.nextInt(4);
                distribution.add(Integer.toString(r)+"%");
            }
            if (list.get(k).isCorrect() == false) {
                int r = 18 + rand.nextInt(5);
                distribution.add(Integer.toString(r)+"%");
            }
            distributionList.add(distribution);
        }
        handlingOfAnsweringQuestion answeringQuestionHandling = new handlingOfAnsweringQuestion();
        for(int i=0; i<distributionList.size(); i++) {
            int id = i+1;
            System.out.println("\u001B[34m" + id + ". " + distributionList.get(i).get(0) + " - " + distributionList.get(i).get(1) + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        answeringQuestionHandling.chooseAnswerOption(gS, question, list);
    }

    public void displayFiftyFifty(GameSession gS, Question question, List<Answer> list) throws SQLException, InputMismatchException {
        fiftyFiftyUsage ++;
        handlingOfAnsweringQuestion answeringQuestionHandling = new handlingOfAnsweringQuestion();
        int rightAnswerIndex = 0;
        int wrongAnswerIndex = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrect() == true) {
                rightAnswerIndex = i;
                break;
            }
        }
        List<Answer> wrongAnswersList = new ArrayList<Answer>();
        for (int i=0; i<list.size(); i++) {
            if(list.get(i).isCorrect() == false) {
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
        answeringQuestionHandling.chooseAnswerOption(gS, question, list);
    }
}

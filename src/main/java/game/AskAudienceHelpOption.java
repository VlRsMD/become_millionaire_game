package game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class AskAudienceHelpOption {
    public boolean optionUsed;

    public AskAudienceHelpOption() {
        this.optionUsed = false;
    }

    public void askAudience (GameSession gS, Question question, List<Answer> list, FiftyFiftyHelpOption fiftyFiftyHelpOption, AskAudienceHelpOption askAudienceHelpOption, PhoneFriendHelpOption phoneFriendHelpOption) throws SQLException, InputMismatchException {
        Random rand = new Random();
        List<List<String>> distributionList = new ArrayList<List<String>>();
        for (Answer answer : list) {
            List<String> distribution = new ArrayList<String>();
            distribution.add(answer.getAnswer());
            if (answer.isCorrect()) {
                int r = 31 + rand.nextInt(4);
                distribution.add(Integer.toString(r) + "%");
            }
            if (!answer.isCorrect()) {
                int r = 18 + rand.nextInt(5);
                distribution.add(Integer.toString(r) + "%");
            }
            distributionList.add(distribution);
        }
        HandlingOfAnsweringQuestion answeringQuestionHandling = new HandlingOfAnsweringQuestion();
        for(int i=0; i<distributionList.size(); i++) {
            int id = i+1;
            System.out.println("\u001B[34m" + id + ". " + distributionList.get(i).get(0) + " - " + distributionList.get(i).get(1) + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        answeringQuestionHandling.chooseAnswerOption(gS, question, list, fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
        optionUsed = true;
    }
}

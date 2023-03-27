package game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandlingOfAnsweringQuestion {
    public void displayAndAnswerQuestion(GameSession gS, Question question, int level, FiftyFiftyHelpOption fiftyFiftyHelpOption, AskAudienceHelpOption askAudienceHelpOption, PhoneFriendHelpOption phoneFriendHelpOption) throws SQLException {
        // print out the level of current question and the question itself
        System.out.println("Level " + level + " question: " + question.getQuestion());
        List<Answer> answersList = new ArrayList<Answer>();
        for (int i = 0; i < question.getAnswersOptions().length; i++) {
            answersList.add(question.getAnswersOptions()[i]);
        }
        Collections.shuffle(answersList);
        // print out answer options
        for (int j = 0; j < answersList.size(); j ++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + answersList.get(j).getAnswer());
        }
        chooseAnswerOption(gS, question, answersList, fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
    }

    public void chooseAnswerOption(GameSession gS, Question question, List<Answer> answersList, FiftyFiftyHelpOption fiftyFiftyHelpOption, AskAudienceHelpOption askAudienceHelpOption, PhoneFriendHelpOption phoneFriendHelpOption) throws SQLException {
        HandlingOfAnswerResult answerResultHandling = new HandlingOfAnswerResult();
        StringScanner scanner = new StringScanner();
        System.out.println("Introduce the number of the correct answer. " + offerHelpOptions(fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption));
        String id = scanner.scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (answersList.get(Integer.parseInt(id) - 1).isCorrect()) {
                answerResultHandling.handleCorrectAnswer(gS, question);
            }
            // in case the answer introduced is incorrect
            else {
                answerResultHandling.handleIncorrectAnswer(gS);
            }
        } else if (id.equals("a") && !askAudienceHelpOption.optionUsed) {
            askAudienceHelpOption.askAudience(gS, question, answersList, fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
        } else if (id.equals("p") && !phoneFriendHelpOption.optionUsed) {
            phoneFriendHelpOption.phoneFriend(gS, question, answersList);
        } else if (id.equals("f") && !fiftyFiftyHelpOption.optionUsed) {
            fiftyFiftyHelpOption.displayFiftyFifty(gS, question, answersList, fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
        } else {
            System.out.println("Invalid input. Try again: ");
            chooseAnswerOption(gS, question, answersList, fiftyFiftyHelpOption, askAudienceHelpOption, phoneFriendHelpOption);
        }
    }

    public String offerHelpOptions(FiftyFiftyHelpOption fiftyFiftyHelpOption, AskAudienceHelpOption askAudienceHelpOption, PhoneFriendHelpOption phoneFriendHelpOption) {
        String availableHelp = "";
        if(fiftyFiftyHelpOption.optionUsed && askAudienceHelpOption.optionUsed && phoneFriendHelpOption.optionUsed) {
            availableHelp = "";
        }
        if(fiftyFiftyHelpOption.optionUsed && !askAudienceHelpOption.optionUsed && !phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'.";
        }
        if(!fiftyFiftyHelpOption.optionUsed && askAudienceHelpOption.optionUsed && !phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Phone a Friend', '50/50'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.";
        }
        if(!fiftyFiftyHelpOption.optionUsed && !askAudienceHelpOption.optionUsed && phoneFriendHelpOption.optionUsed){
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the '50/50' option type 'f'.";
        }
        if(fiftyFiftyHelpOption.optionUsed && askAudienceHelpOption.optionUsed && !phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use the following help option: 'Phone a Friend'. In order to choose the 'Phone a Friend' option type 'p'.";
        }
        if(!fiftyFiftyHelpOption.optionUsed && askAudienceHelpOption.optionUsed && phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use the following help option: '50/50'. In order to choose the '50/50' option type 'f'.";
        }
        if(fiftyFiftyHelpOption.optionUsed && !askAudienceHelpOption.optionUsed && phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use the following help option: 'Ask the Audience'. In order to choose the 'Ask the Audience' option type 'a'.";
        }
        if(!fiftyFiftyHelpOption.optionUsed && !askAudienceHelpOption.optionUsed && !phoneFriendHelpOption.optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.";
        }
        return availableHelp;
    }
}

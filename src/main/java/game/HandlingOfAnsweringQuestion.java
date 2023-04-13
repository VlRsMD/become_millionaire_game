package game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandlingOfAnsweringQuestion {
    public void displayAndAnswerQuestion(GameSession gS, Question question, int level) throws SQLException {
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
        chooseAnswerOption(gS, question, level, answersList);
    }

    public void displayAndAnswerQuestionOnceAgain(GameSession gS, Question question, int level, List<Answer> answersList) throws SQLException {
        // print out the level of current question and the question itself
        System.out.println("Level " + level + " question: " + question.getQuestion());
        // print out answer options
        for (int j = 0; j < answersList.size(); j ++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + answersList.get(j).getAnswer());
        }
        chooseAnswerOption(gS, question, level, answersList);
    }

    public void chooseAnswerOption(GameSession gS, Question question, int level, List<Answer> answersList) throws SQLException {
        HandlingOfAnswerResult answerResultHandling = new HandlingOfAnswerResult();
        StringScanner scanner = new StringScanner();
        System.out.println("Introduce the number of the correct answer. " + offerHelpOptions(gS));
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
        } else if (id.equals("a") && !gS.getAskAudienceHelpOption().optionUsed) {
            gS.getAskAudienceHelpOption().askAudience(answersList);
            displayAndAnswerQuestionOnceAgain(gS, question, level, answersList);
        } else if (id.equals("p") && !gS.getPhoneFriendHelpOption().optionUsed) {
            gS.getPhoneFriendHelpOption().phoneFriend(answersList);
            displayAndAnswerQuestionOnceAgain(gS, question, level, answersList);
        } else if (id.equals("f") && !gS.getFiftyFiftyHelpOption().optionUsed) {
            gS.getFiftyFiftyHelpOption().displayFiftyFifty(answersList);
            displayAndAnswerQuestionOnceAgain(gS, question, level, answersList);
        } else {
            System.out.println("Invalid input. Try again: ");
            chooseAnswerOption(gS, question, level, answersList);
        }
    }

    public String offerHelpOptions(GameSession gS) {
        String availableHelp = "";
        if(gS.getFiftyFiftyHelpOption().optionUsed && gS.getAskAudienceHelpOption().optionUsed && gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "";
        }
        if(gS.getFiftyFiftyHelpOption().optionUsed && !gS.getAskAudienceHelpOption().optionUsed && !gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'.";
        }
        if(!gS.getFiftyFiftyHelpOption().optionUsed && gS.getAskAudienceHelpOption().optionUsed && !gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Phone a Friend', '50/50'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.";
        }
        if(!gS.getFiftyFiftyHelpOption().optionUsed && !gS.getAskAudienceHelpOption().optionUsed && gS.getPhoneFriendHelpOption().optionUsed){
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the '50/50' option type 'f'.";
        }
        if(gS.getFiftyFiftyHelpOption().optionUsed && gS.getAskAudienceHelpOption().optionUsed && !gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use the following help option: 'Phone a Friend'. In order to choose the 'Phone a Friend' option type 'p'.";
        }
        if(!gS.getFiftyFiftyHelpOption().optionUsed && gS.getAskAudienceHelpOption().optionUsed && gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use the following help option: '50/50'. In order to choose the '50/50' option type 'f'.";
        }
        if(gS.getFiftyFiftyHelpOption().optionUsed && !gS.getAskAudienceHelpOption().optionUsed && gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use the following help option: 'Ask the Audience'. In order to choose the 'Ask the Audience' option type 'a'.";
        }
        if(!gS.getFiftyFiftyHelpOption().optionUsed && !gS.getAskAudienceHelpOption().optionUsed && !gS.getPhoneFriendHelpOption().optionUsed) {
            availableHelp = "You can also use once each of the following help options: 'Ask the Audience', 'Phone a Friend', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.";
        }
        return availableHelp;
    }
}

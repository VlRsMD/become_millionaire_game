package game;

import java.util.UUID;

public class GameSession {
    private String uuid;
    private String username;
    private int score;
    private QuestionsBank questionsBank;
    private FiftyFiftyHelpOption fiftyFiftyHelpOption;
    private AskAudienceHelpOption askAudienceHelpOption;
    private PhoneFriendHelpOption phoneFriendHelpOption;

    public GameSession() {
        this.uuid = UUID.randomUUID().toString();
        this.questionsBank = new QuestionsBank();
        this.fiftyFiftyHelpOption = new FiftyFiftyHelpOption();
        this.askAudienceHelpOption = new AskAudienceHelpOption();
        this.phoneFriendHelpOption = new PhoneFriendHelpOption();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QuestionsBank getQuestionsBank() {
        return questionsBank;
    }

    public FiftyFiftyHelpOption getFiftyFiftyHelpOption() {
        return fiftyFiftyHelpOption;
    }

    public AskAudienceHelpOption getAskAudienceHelpOption() {
        return askAudienceHelpOption;
    }

    public PhoneFriendHelpOption getPhoneFriendHelpOption() {
        return phoneFriendHelpOption;
    }
}

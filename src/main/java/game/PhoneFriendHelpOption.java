package game;

import java.sql.SQLException;
import java.util.List;

public class PhoneFriendHelpOption {
    public boolean optionUsed;

    public PhoneFriendHelpOption() {
        this.optionUsed = false;
    }

    public void phoneFriend (GameSession gS, Question question, List<Answer> list) throws SQLException {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrect()) {
                int id = i+1;
                System.out.println("\u001B[34m" + "The right answer is nr. " + id + ": " + list.get(i).getAnswer()+"."  + "\u001B[0m");
                break;
            }
        }
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Your current score is " + gS.getScore() + " points." + "\u001B[0m");
        optionUsed = true;
    }
}

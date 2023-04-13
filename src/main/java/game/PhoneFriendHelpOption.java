package game;

import java.util.List;

public class PhoneFriendHelpOption {
    public boolean optionUsed;

    public PhoneFriendHelpOption() {
        this.optionUsed = false;
    }

    public void phoneFriend (List<Answer> list) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrect()) {
                int id = i+1;
                System.out.println("\u001B[34m" + "The right answer is nr. " + id + ": " + list.get(i).getAnswer()+"."  + "\u001B[0m");
                break;
            }
        }
        optionUsed = true;
    }
}

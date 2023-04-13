package game;

import java.util.*;

public class FiftyFiftyHelpOption {
    public boolean optionUsed;

    public FiftyFiftyHelpOption() {
        this.optionUsed = false;
    }

    public void displayFiftyFifty(List<Answer> list) throws InputMismatchException {
        int rightAnswerIndex = 0;
        int wrongAnswerIndex = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrect()) {
                rightAnswerIndex = i;
                break;
            }
        }
        List<Answer> wrongAnswersList = new ArrayList<Answer>();
        for (Answer answer : list) {
            if (!answer.isCorrect()) {
                wrongAnswersList.add(answer);
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
        optionUsed = true;
    }
}

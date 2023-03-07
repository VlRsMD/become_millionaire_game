package game;

public class Question {
    int id;
    String question;
    String [] answersOptions;
    int rightOption;
    int score;

    public Question(int id, String question, String[] answersOptions, int rightOption, int score) {
        this.id = id;
        this.question = question;
        this.answersOptions = answersOptions;
        this.rightOption = rightOption;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswersOptions() {
        return answersOptions;
    }

    public void setAnswersOptions(String[] answersOptions) {
        this.answersOptions = answersOptions;
    }

    public int getRightOption() {
        return rightOption;
    }

    public void setRightOption(int rightOptionInd) {
        this.rightOption = rightOptionInd;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

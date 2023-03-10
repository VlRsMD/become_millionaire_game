package game;

import java.util.UUID;

public class Question {
    private String uuid;
    private String question;
    private Answer [] answersOptions;
    private int score;

    public Question(String question, Answer[] answersOptions, int score) {
        this.uuid = UUID.randomUUID().toString();
        this.question = question;
        this.answersOptions = answersOptions;
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswersOptions() {
        return answersOptions;
    }

    public void setAnswersOptions(Answer[] answersOptions) {
        this.answersOptions = answersOptions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

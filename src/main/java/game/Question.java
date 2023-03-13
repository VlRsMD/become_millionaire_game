package game;

import java.util.UUID;

public class Question {
    private String uuid;
    private String question;
    private Answer [] answersOptions;
    private int score;
    private int level;

    public Question(String question, Answer[] answersOptions, int score, int level) {
        this.uuid = UUID.randomUUID().toString();
        this.question = question;
        this.answersOptions = answersOptions;
        this.score = score;
        this.level = level;
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

    public int getLevel() { return level; }

    public void setLevel(int level) { this.level = level; }
}

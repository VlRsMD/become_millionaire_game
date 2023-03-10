package game;

public class Answer {
    private String answer;
    private boolean correctness;
    private int distributionPercentage;

    public Answer(String answer, boolean correctness, int distributionPercentage) {
        this.answer = answer;
        this.correctness = correctness;
        this.distributionPercentage = distributionPercentage;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrectness() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

    public int getDistributionPercentage() {
        return distributionPercentage;
    }

    public void setDistributionPercentage(int distributionPercentage) {
        this.distributionPercentage = distributionPercentage;
    }
}

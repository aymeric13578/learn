package se.aymeric.api.composite.content;

public class QuizSummary {

    private final int quizId;
    private final String title;
    private final int numberOfQuestions;

    public QuizSummary(int quizId, String title, int numberOfQuestions) {
        this.quizId = quizId;
        this.title = title;
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}

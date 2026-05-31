package grades;

/**
 * Represents the percentage weights for each grading component of a course.
 *
 * <p>The four components are: quizzes, project, midterm exam, and final exam.
 * Weights are expressed as integers (e.g. 20 means 20%). It is the caller's
 * responsibility to ensure the four weights sum to 100.</p>
 */
public class Weight {

    /** Weight allocated to quizzes (as a percentage out of 100). */
    private final int quizWeight;

    /** Weight allocated to the project (as a percentage out of 100). */
    private final int projectWeight;

    /** Weight allocated to the midterm exam (as a percentage out of 100). */
    private final int midtermWeight;

    /** Weight allocated to the final exam (as a percentage out of 100). */
    private final int finalExamWeight;

    /**
     * Constructs a {@code Weight} with the given grading component percentages.
     *
     * @param quizWeight      the quiz weight (0–100)
     * @param projectWeight   the project weight (0–100)
     * @param midtermWeight   the midterm exam weight (0–100)
     * @param finalExamWeight the final exam weight (0–100)
     */
    public Weight(int quizWeight, int projectWeight, int midtermWeight, int finalExamWeight) {
        this.quizWeight      = quizWeight;
        this.projectWeight   = projectWeight;
        this.midtermWeight   = midtermWeight;
        this.finalExamWeight = finalExamWeight;
    }

    /**
     * Returns the quiz weight.
     *
     * @return quiz weight as a percentage
     */
    public int getQuizWeight() {
        return quizWeight;
    }

    /**
     * Returns the project weight.
     *
     * @return project weight as a percentage
     */
    public int getProjectWeight() {
        return projectWeight;
    }

    /**
     * Returns the midterm exam weight.
     *
     * @return midterm weight as a percentage
     */
    public int getMidtermWeight() {
        return midtermWeight;
    }

    /**
     * Returns the final exam weight.
     *
     * @return final exam weight as a percentage
     */
    public int getFinalExamWeight() {
        return finalExamWeight;
    }
}

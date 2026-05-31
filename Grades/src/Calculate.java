package grades;

/**
 * Calculates a student's final score for a course based on weighted grading components.
 *
 * <p>Extends {@link Weight} to inherit the grading component weights (quizzes,
 * project, midterm, and final exam). Two score-calculation modes are supported:</p>
 * <ul>
 *   <li>{@link #calculateFinalScore} — standard mode where all quizzes contribute
 *       equal portions of the quiz weight.</li>
 *   <li>{@link #calculateProgrammingScore} — specialised mode for programming courses
 *       where the first and third quizzes share one sub-weight and the second quiz
 *       has its own sub-weight.</li>
 * </ul>
 *
 * <p>All raw scores are expected to be on a 0–100 scale. A score of {@code 0}
 * for a component means that component was not held this term and contributes
 * nothing to the total.</p>
 */
public class Calculate extends Weight {

    /** The raw quiz scores (each in the range 0–100). */
    private double[] quizScores;

    /**
     * Constructs a {@code Calculate} object with the specified grading weights.
     *
     * @param quizWeight      weight of quizzes as a percentage (0–100)
     * @param projectWeight   weight of the project as a percentage (0–100)
     * @param midtermWeight   weight of the midterm exam as a percentage (0–100)
     * @param finalExamWeight weight of the final exam as a percentage (0–100)
     */
    public Calculate(int quizWeight, int projectWeight, int midtermWeight, int finalExamWeight) {
        super(quizWeight, projectWeight, midtermWeight, finalExamWeight);
        this.quizScores = null;
    }

    // -------------------------------------------------------------------------
    // Accessors
    // -------------------------------------------------------------------------

    /**
     * Returns the stored quiz scores array.
     *
     * @return array of raw quiz scores, or {@code null} if not yet set
     */
    public double[] getQuizScores() {
        return quizScores;
    }

    /**
     * Sets the raw quiz scores that will be used in score calculations.
     *
     * @param quizScores array of raw quiz scores (each 0–100)
     */
    public void setQuizScores(double[] quizScores) {
        this.quizScores = quizScores;
    }

    // -------------------------------------------------------------------------
    // Grade-letter helpers
    // -------------------------------------------------------------------------

    /**
     * Converts a numeric score (0–100) to a letter grade string.
     *
     * <p>Grade boundaries:</p>
     * <pre>
     *  [0,  50)  → F
     *  [50, 55)  → D
     *  [55, 60)  → D+
     *  [60, 65)  → C-
     *  [65, 70)  → C
     *  [70, 74)  → C+
     *  [74, 78)  → B-
     *  [78, 82)  → B
     *  [82, 86)  → B+
     *  [86, 90)  → A-
     *  [90, 94)  → A
     *  [94, 100] → A+
     * </pre>
     *
     * @param score the numeric score (0–100)
     * @return the corresponding letter grade
     */
    public String scoreToLetterGrade(double score) {
        if (score < 50) return "F";
        if (score < 55) return "D";
        if (score < 60) return "D+";
        if (score < 65) return "C-";
        if (score < 70) return "C";
        if (score < 74) return "C+";
        if (score < 78) return "B-";
        if (score < 82) return "B";
        if (score < 86) return "B+";
        if (score < 90) return "A-";
        if (score < 94) return "A";
        return "A+";
    }

    /**
     * Prints the letter grade that corresponds to the supplied numeric score.
     *
     * @param score the numeric score (0–100)
     */
    public void printLetterGrade(double score) {
        System.out.println(scoreToLetterGrade(score));
    }

    // -------------------------------------------------------------------------
    // Score-calculation helpers
    // -------------------------------------------------------------------------

    /**
     * Computes the weighted quiz contribution using the <em>standard</em> model,
     * where every quiz carries an equal share of the total quiz weight.
     *
     * <p>Formula per quiz: {@code (rawScore / 100) × (quizWeight / numQuizzes)}</p>
     *
     * @param quizzes array of raw quiz scores (each 0–100)
     * @return the total weighted quiz score (out of {@code quizWeight} percent)
     */
    public double calculateQuizScore(double[] quizzes) {
        double total = 0.0;
        double perQuizWeight = (double) getQuizWeight() / quizzes.length;

        for (double score : quizzes) {
            total += (score / 100.0) * perQuizWeight;
        }
        return total;
    }

    // -------------------------------------------------------------------------
    // Final score calculators
    // -------------------------------------------------------------------------

    /**
     * Calculates the overall course score using the <em>standard</em> grading model.
     *
     * <p>Each component (project, midterm, final exam) is scaled by its
     * respective weight. Pass {@code 0} for any component that was not held.</p>
     *
     * @param quizzes      array of raw quiz scores (each 0–100)
     * @param projectScore raw project score (0–100), or 0 if not applicable
     * @param midtermScore raw midterm score (0–100), or 0 if not applicable
     * @param finalScore   raw final exam score (0–100), or 0 if not applicable
     * @return the weighted total score (0–100)
     */
    public double calculateFinalScore(double[] quizzes,
                                      double projectScore,
                                      double midtermScore,
                                      double finalScore) {
        double weightedProject  = (projectScore / 100.0) * getProjectWeight();
        double weightedMidterm  = (midtermScore  / 100.0) * getMidtermWeight();
        double weightedFinal    = (finalScore    / 100.0) * getFinalExamWeight();
        return calculateQuizScore(quizzes) + weightedProject + weightedMidterm + weightedFinal;
    }

}

package grades;

/**
 * Entry point for the Grades application.
 *
 * <p>Computes and prints the weighted final score (as a percentage) for each
 * enrolled course using the actual quiz, project, midterm, and final-exam scores
 * together with each course's predefined grading weights.</p>
 *
 * <p>Course weight constructor signature:
 * {@code new Calculate(quizWeight, projectWeight, midtermWeight, finalExamWeight)}</p>
 */
public class Main {

    public static void main(String[] args) {

        // ------------------------------------------------------------------
        // Define grading weights for each course.
        // Constructor: Calculate(quizWeight, projectWeight, midtermWeight, finalExamWeight)
        // ------------------------------------------------------------------
        Calculate math        = new Calculate(20, 10, 30, 40);
        Calculate org         = new Calculate(20, 20, 25, 35);
        Calculate programming = new Calculate(40, 20, 20, 20);
        Calculate networking  = new Calculate(20, 20, 20, 40);
        Calculate theoretical = new Calculate(40,  0, 20, 40);

    }
}

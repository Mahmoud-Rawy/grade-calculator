# Grade Calculator

A Java console application that computes weighted final scores and letter grades for university courses — built with clean OOP design and full Javadoc documentation.

---

## 🗂️ Project Structure

```
Grades/
└── src/
    └── grades/
        ├── Main.java        # Entry point — courses and scores are configured here
        ├── Calculate.java   # Score calculation and letter grade logic (extends Weight)
        └── Weight.java      # Stores the percentage weight breakdown for a course
```

---

## ⚙️ How It Works

### `Weight.java`
An immutable base class that holds the four grading component weights for a course. All weights are expressed as integers (e.g. `20` means 20%) and should sum to 100.

```java
new Weight(quizWeight, projectWeight, midtermWeight, finalExamWeight)
```

### `Calculate.java`
Extends `Weight` and handles all score computation. Raw scores are passed in on a 0–100 scale. Pass `0` for any component that wasn't held that term.

**Standard courses** — all quizzes contribute equally to the quiz weight:
```java
calculate.calculateFinalScore(quizzes, projectScore, midtermScore, finalScore)
```

**Letter grade conversion** — an instance method that maps a numeric score to a grade string:
```java
calculate.scoreToLetterGrade(score)   // returns "A+", "B-", "F", etc.
calculate.printLetterGrade(score)     // prints the letter grade to console
```

### `Main.java`
The entry point. Courses are pre-configured with their weight breakdowns. Add your raw scores and call `calculateFinalScore()` to compute results.

**Courses currently defined:**

| Course | Quiz | Project | Midterm | Final |
|--------|------|---------|---------|-------|
| Math | 20% | 10% | 30% | 40% |
| Computer Organization | 20% | 20% | 25% | 35% |
| Programming | 40% | 20% | 20% | 20% |
| Networking | 20% | 20% | 20% | 40% |
| Theoretical CS | 40% | 0% | 20% | 40% |

---

## ▶️ How to Run

1. Clone or download the repository
2. Open Eclipse → `File` → `Open Projects from File System` → select the `Grades` folder
3. Open `src/grades/Main.java`
4. Set your quiz scores using `setQuizScores()` and call `calculateFinalScore()` for each course
5. Run `Main.java` — results print to the console

**Requirements:** Java 11 or later · Eclipse IDE (recommended)

---

## 💡 Usage Example

```java
Calculate math = new Calculate(20, 10, 30, 40);
math.setQuizScores(new double[]{85, 90});

double score = math.calculateFinalScore(math.getQuizScores(), 80, 75, 88);
System.out.println("Math : " + score + "%");
System.out.println("Grade: " + math.scoreToLetterGrade(score));
```

Output:
```
Math : 81.5%
Grade: B
```

---

## 📐 Grading Scale

| Score | Grade | Score | Grade |
|-------|-------|-------|-------|
| 94–100 | A+  | 70–73 | C+    |
| 90–93  | A   | 65–69 | C     |
| 86–89  | A-  | 60–64 | C-    |
| 82–85  | B+  | 55–59 | D+    |
| 78–81  | B   | 50–54 | D     |
| 74–77  | B-  | < 50  | F     |

---

## 👤 Author

**Mahmoud M. Rawy** — CS Student at GIU Cairo  
[LinkedIn](https://linkedin.com/in/mahmoud-rawy-4b3687409) · [GitHub](https://github.com/Mahmoud-Rawy)

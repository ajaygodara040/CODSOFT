# Student Grade Calculator

A console-based Java program that calculates a student's total marks, average percentage, and grade based on marks entered for multiple subjects.

## How It Works

- The program asks how many subjects the student has appeared in.
- For each subject, it asks for marks obtained (out of 100).
  - If you enter an invalid value (less than 0 or more than 100), it will keep asking until you enter a valid value.
- Once all marks are entered, it calculates:
  - **Total Marks** (sum of all subject marks)
  - **Average Percentage** = Total Marks ÷ Number of Subjects
  - **Grade** based on the average percentage

## Grading Scale

| Percentage Range | Grade     |
|-------------------|-----------|
| 90 and above      | A+        |
| 80 – 89.99         | A         |
| 70 – 79.99         | B         |
| 60 – 69.99         | C         |
| 50 – 59.99         | D         |
| 40 – 49.99         | E         |
| Below 40          | F (Fail)  |

## Requirements

- Java JDK 8 or above installed on your system.

## How to Run

1. Save the file as `StudentGradeCalculator.java`.
2. Open a terminal in the folder containing the file.
3. Compile the program:
   ```
   javac StudentGradeCalculator.java
   ```
4. Run the program:
   ```
   java StudentGradeCalculator
   ```

## Sample Run

```
Enter the number of subjects: 3
Enter marks obtained in subject 1 (out of 100): 85
Enter marks obtained in subject 2 (out of 100): 92
Enter marks obtained in subject 3 (out of 100): 78

=== Result ===
Total Subjects    : 3
Total Marks       : 255 / 300
Average Percentage: 85.00%
studentGrade           : A
```

## Possible Improvements

- Allow subject names to be entered along with marks.
- Display marks for each subject in the final result.
- Add support for weighted subjects (credits/weightage).
- Save results to a file or generate a report card.
- Add input validation for the number of subjects (e.g., reject 0 or negative values).

## Author

Ajay Kumar
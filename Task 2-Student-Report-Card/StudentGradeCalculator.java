import  java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjectCount = sc.nextInt();

        int[] marks = new int[subjectCount];
        int totalMarks = 0;

        for (int i = 0; i < subjectCount; i++) {
            int subjectMarks;

            while (true) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                subjectMarks = sc.nextInt();

                if (subjectMarks < 0 || subjectMarks > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                } else {
                    break;
                }
            }

            marks[i] = subjectMarks;
            totalMarks += subjectMarks;
        }

        double averagePercentage = (double) totalMarks / subjectCount;
        String StudentGrade = calculateStudentGrade(averagePercentage);

        System.out.println("\n=== Result ===");
        System.out.println("Total Subjects    : " + subjectCount);
        System.out.println("Total Marks       : " + totalMarks + " / " + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("studentGrade           : " + StudentGrade);

        sc.close();
    }

    static String calculateStudentGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F (Fail)";
        }
    }
}


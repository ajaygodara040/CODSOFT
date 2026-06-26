import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random rng = new Random();

    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 100;
    static final int TOTAL_TRIES = 7;

    public static void main(String[] args) {
        int roundsWon = 0;
        int roundsPlayed = 0;
        int totalScore = 0;

        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        while (playAgain) {
            roundsPlayed++;
            int result = playOneRound();

            if (result > 0) {
                roundsWon++;
                totalScore += result; // higher score for fewer TRIES
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next().trim().toLowerCase();
            playAgain = choice.equals("yes") || choice.equals("y");
        }

        System.out.println("\n=== Game Over ===");
        System.out.println("Rounds played : " + roundsPlayed);
        System.out.println("Rounds won    : " + roundsWon);
        System.out.println("Total score   : " + totalScore);
    }

    // Returns score for the round (0 if the user lost the round)
    static int playOneRound() {
        int target = MIN_RANGE + rng.nextInt(MAX_RANGE - MIN_RANGE + 1);
        int TRIESUsed = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nNew round started! Guess a number between "
                + MIN_RANGE + " and " + MAX_RANGE + ".");
        System.out.println("You have " + TOTAL_TRIES + " TRIES.");

        while (TRIESUsed < TOTAL_TRIES && !guessedCorrectly) {
            System.out.print("TRIES " + (TRIESUsed + 1) + ": Enter your guess: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                sc.next(); // discard invalid input
                continue;
            }

            int guess = sc.nextInt();
            TRIESUsed++;

            if (guess == target) {
                guessedCorrectly = true;
                System.out.println("Correct! You guessed it in " + TRIESUsed + " attempt(s).");
            } else if (guess > target) {
                System.out.println("Too high.");
            } else {
                System.out.println("Too low.");
            }
        }

        if (guessedCorrectly) {
            // Fewer TRIES -> higher score
            int score = (TOTAL_TRIES - TRIESUsed + 1) * 10;
            System.out.println("Score for this round: " + score);
            return score;
        } else {
            System.out.println("Out of TRIES! The number was " + target + ".");
            return 0;
        }
    }
}

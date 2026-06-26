# NumberGuessingGame
# Number Guessing Game

A simple console-based Number Guessing Game written in Java. The computer picks a random number, and you try to guess it within a limited number of tries. Play multiple rounds and track your total score!

## How It Works

- The program randomly selects a number between **1 and 100**.
- You get **7 tries** per round to guess the number.
- After every guess, the game tells you if your guess was **too high** or **too low**.
- If you guess correctly, you earn points based on how quickly you guessed:
  - **Score = (7 - tries used + 1) × 10**
  - Fewer tries = higher score.
- If you run out of tries, the round ends and the correct number is revealed.
- After each round, you can choose to play another round or end the game.
- At the end, the game shows:
  - Total rounds played
  - Total rounds won
  - Total score across all rounds

## Requirements

- Java JDK 8 or above installed on your system.

## How to Run

1. Save the file as `NumberGuessingGame.java`.
2. Open a terminal in the folder containing the file.
3. Compile the program:
   ```
   javac NumberGuessingGame.java
   ```
4. Run the program:
   ```
   java NumberGuessingGame
   ```

## Sample Gameplay

```
=== Welcome to the Number Guessing Game ===

New round started! Guess a number between 1 and 100.
You have 7 tries.
Try 1: Enter your guess: 50
Too high.
Try 2: Enter your guess: 25
Too low.
Try 3: Enter your guess: 35
Correct! You guessed it in 3 attempt(s).
Score for this round: 50

Do you want to play another round? (yes/no): no

=== Game Over ===
Rounds played : 1
Rounds won    : 1
Total score   : 50
```

## Game Rules

| Rule              | Value          |
|-------------------|----------------|
| Number range      | 1 to 100       |
| Tries per round    | 7              |
| Scoring formula   | (7 - tries used + 1) × 10 |

## Possible Improvements

- Add difficulty levels (easy/medium/hard) with different ranges and try limits.
- Save high scores to a file.
- Add input validation for the range (e.g., reject guesses outside 1–100).
- Add a hint system (e.g., "very close" vs "far off").

## Author

Ajay Kumar

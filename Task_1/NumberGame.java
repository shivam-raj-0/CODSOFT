package Task_1;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        char playAgain;
        int totalScore = 0;

        do {

            int number = rand.nextInt(100) + 1; // Point 1 1 to 100 random number generate
            int guess;
            int attempts = 0;
            int maxAttempts = 7; // Point 5 number of attempts

            System.out.println("\n===== Number Guessing Game =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) { // Point 4 attempts count

                System.out.print("Enter your guess: ");
                guess = sc.nextInt(); // Point 2 user guess number
                attempts++;

                if (guess == number) { // Point 3 compare user guess number or system guess number 
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    break;
                }
                else if (guess > number) {
                    System.out.println("Too High!");
                }
                else {
                    System.out.println("Too Low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The number was: " + number);
            }

            // Point 7: Score based on attempts
            if (guessedCorrectly) {
                int score = (maxAttempts - attempts + 1) * 10;
                totalScore += score;
                System.out.println("Your score this round: " + score);
            }

            System.out.println("Total Score: " + totalScore);

            // Point 6: Multiple rounds
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");

        sc.close();
    }
}

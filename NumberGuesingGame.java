import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;

        do {
            int totalScore = 0;  // Reset the score for each new game

            int rounds = 0;
            while (rounds <= 0) {
                System.out.print("How many rounds would you like to play? ");
                if (scanner.hasNextInt()) {
                    rounds = scanner.nextInt();
                    if (rounds <= 0) {
                        System.out.println("Please enter a positive number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();  // Clear the invalid input
                }
            }

            for (int roundNumber = 1; roundNumber <= rounds; roundNumber++) {
                System.out.println("\n--- Round " + roundNumber + " ---");
                Random random = new Random();
                int numberToGuess = random.nextInt(100) + 1;
                int attempts = 0;
                int maxAttempts = 10;
                boolean guessedCorrectly = false;

                while (attempts < maxAttempts) {
                    System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess (1-100): ");
                    int guess = 0;
                    if (scanner.hasNextInt()) {
                        guess = scanner.nextInt();
                        if (guess < 1 || guess > 100) {
                            System.out.println("Please enter a number between 1 and 100.");
                            continue;  // Skip the rest of the loop and ask again
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();  // Clear the invalid input
                        continue;  // Skip the rest of the loop and ask again
                    }

                    attempts++;

                    if (guess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        totalScore += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                        guessedCorrectly = true;
                        break;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
                }
            }

            System.out.println("\nGame over! Your total score is " + totalScore + " points.");
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
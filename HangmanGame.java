import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Get player name
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("Good Luck ! " + name);

        // Word list
        String[] words = {"dream", "computer", "soft", "programming",
                          "java", "mathematics", "palindrome", "condition",
                          "reverse", "water", "smartwork", "geeks"};

        // Pick a random word
        String word = words[random.nextInt(words.length)];

        System.out.println("Guess the characters");

        StringBuilder guesses = new StringBuilder();
        int turns = 12;

        while (turns > 0) {
            int failed = 0;

            // Display the guessed word with underscores
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (guesses.toString().contains(String.valueOf(ch))) {
                    System.out.print(ch + " ");
                } else {
                    System.out.print("_ ");
                    failed++;
                }
            }

            System.out.println();

            if (failed == 0) {
                System.out.println("You Win");
                System.out.println("The word is: " + word);
                break;
            }

            // Ask for user's guess
            System.out.print("Guess a character: ");
            String guessInput = scanner.nextLine();
            char guess = guessInput.charAt(0);

            guesses.append(guess);

            if (!word.contains(String.valueOf(guess))) {
                turns--;
                System.out.println("Wrong");
                System.out.println("You have " + turns + " more guesses");

                if (turns == 0) {
                    System.out.println("You Lose");
                    System.out.println("The word was: " + word);
                }
            }
        }

        scanner.close();
    }
}

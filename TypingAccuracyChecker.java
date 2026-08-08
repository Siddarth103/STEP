package STEP;
import java.util.Scanner;

/**
 * Problem 2 - The Typing Speed Test Accuracy Checker
 *
 * Compares the passage shown to the user with the text the user actually
 * typed, character by character, and reports the accuracy percentage plus
 * the position of the very first mistake.
 */
public class TypingAccuracyChecker {

    /**
     * Compares two equal-length strings position by position and prints the
     * match count, the accuracy percentage and the first mismatch position.
     */
    void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: text cannot be empty.");
            return;
        }
        if (original.length() != typed.length()) {
            System.out.println("Invalid input: both strings must be of equal length.");
            return;
        }

        int total = original.length();
        if (total == 0) {
            System.out.println("Invalid input: text cannot be empty.");
            return;
        }

        int matched = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                // Remember only the earliest mismatch position.
                firstMismatchIndex = i;
            }
        }

        double accuracy = (matched * 100.0) / total;

        String result = "Matched: " + matched + "/" + total
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%";

        if (firstMismatchIndex == -1) {
            result = result + " | No Mismatches";
        } else {
            // Positions are reported to the user as 1-based.
            result = result + " | First Mismatch at position " + (firstMismatchIndex + 1)
                    + " ('" + original.charAt(firstMismatchIndex)
                    + "' vs '" + typed.charAt(firstMismatchIndex) + "')";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TypingAccuracyChecker checker = new TypingAccuracyChecker();

        System.out.print("Enter the original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter the typed text        : ");
        String typed = sc.nextLine();

        System.out.println();
        checker.checkTypingAccuracy(original, typed);

        sc.close();
    }
}

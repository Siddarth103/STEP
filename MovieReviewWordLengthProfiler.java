package STEP;
import java.util.Scanner;

/**
 * Problem 5 - The Movie Review Word Length Profiler
 *
 * Splits a submitted review into words and counts how many are Short (1-4
 * letters), Medium (5-8 letters) or Long (9+ letters), so moderators get a
 * quick spam profile of the review before it goes live.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits the review on whitespace and counts the words in each length
     * category. Only letters are counted, so trailing punctuation such as
     * "fantastic!" does not push a word into the next category.
     */
    void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (int i = 0; i < words.length; i++) {

            int letters = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (Character.isLetter(words[i].charAt(j))) {
                    letters++;
                }
            }

            if (letters == 0) {
                continue;   // token was pure punctuation, not a word
            }

            if (letters <= 4) {
                shortCount++;
            } else if (letters <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount
                + " | Medium: " + mediumCount
                + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieReviewWordLengthProfiler profiler = new MovieReviewWordLengthProfiler();

        System.out.print("Enter the movie review: ");
        String review = sc.nextLine();

        System.out.println();
        profiler.classifyWordLengths(review);

        sc.close();
    }
}

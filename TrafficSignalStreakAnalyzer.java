package STEP;
import java.util.Scanner;

/**
 * Problem 3 - The Traffic Signal Streak Analyzer
 *
 * Scans a day's signal log ('R' red, 'Y' yellow, 'G' green - one reading per
 * minute) and reports the longest continuous run of the same colour, so the
 * engineers know which signal may be stuck.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Walks through the log once, measuring each streak of identical
     * characters and keeping the longest one seen so far.
     */
    void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Signal log is empty - nothing to analyze.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            // Strictly greater, so the earliest streak wins on a tie.
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated "
                + longestLength + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrafficSignalStreakAnalyzer analyzer = new TrafficSignalStreakAnalyzer();

        System.out.print("Enter the signal log (e.g. RRGGGYRR): ");
        String signalLog = sc.nextLine().trim();

        System.out.println();
        analyzer.findLongestStreak(signalLog);

        sc.close();
    }
}

package STEP;
import java.util.Scanner;

/**
 * Problem 1 - The Exam Hall Seat Duplication Checker
 *
 * Scans the list of seat numbers assigned to students and flags any seat
 * number that has been given to more than one student.
 *
 * Constraint: no Collections classes are used - plain arrays and loops only.
 */
public class SeatDuplicationChecker {

    /**
     * Compares every seat number against every other seat number and prints
     * each duplicated seat number exactly once.
     */
    void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            // Skip this seat if the same value appeared earlier in the array,
            // otherwise a seat repeated three times would be printed twice.
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            // Count how many times this seat number occurs after position i.
            int repeatCount = 0;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[j] == seatNumbers[i]) {
                    repeatCount++;
                }
            }

            if (repeatCount > 0) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SeatDuplicationChecker checker = new SeatDuplicationChecker();

        System.out.print("Enter the number of students in the hall: ");
        int count = sc.nextInt();

        int[] seatNumbers = new int[count];
        System.out.println("Enter " + count + " seat numbers:");
        for (int i = 0; i < count; i++) {
            seatNumbers[i] = sc.nextInt();
        }

        System.out.println();
        checker.checkDuplicateSeats(seatNumbers);

        sc.close();
    }
}

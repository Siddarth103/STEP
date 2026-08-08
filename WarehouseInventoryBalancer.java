package STEP;
import java.util.Scanner;

/**
 * Problem 4 - The Warehouse Inventory Balancer
 *
 * Compares the total stock held in Section A against Section B to catch
 * data-entry mismatches, and reports the single highest-quantity item found
 * anywhere in the warehouse.
 */
public class WarehouseInventoryBalancer {

    /**
     * Prints both section totals, the balanced/not-balanced status, and the
     * highest quantity along with the section and item number it sits at.
     */
    void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null
                || sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid input: both sections must contain items.");
            return;
        }
        if (sectionA.length != sectionB.length) {
            System.out.println("Invalid input: both sections must have the same number of items.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Scan Section A first, then Section B, keeping the first occurrence
        // of the maximum (strictly greater comparison).
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest
                + " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();

        System.out.print("Enter the number of item categories: ");
        int count = sc.nextInt();

        int[] sectionA = new int[count];
        int[] sectionB = new int[count];

        System.out.println("Enter " + count + " quantities for Section A:");
        for (int i = 0; i < count; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter " + count + " quantities for Section B:");
        for (int i = 0; i < count; i++) {
            sectionB[i] = sc.nextInt();
        }

        System.out.println();
        balancer.analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}

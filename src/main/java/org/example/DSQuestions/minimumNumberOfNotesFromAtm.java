package org.example.DSQuestions;

import java.util.Scanner;

public class minimumNumberOfNotesFromAtm {

//improve the logic if a person can withdrawn equals to minimum denominations note
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw (multiple of 100): ");
        int amount = scanner.nextInt();

        if (amount < 100 || amount % 100 != 0) {
            System.out.println("Invalid amount. It must be a multiple of 100 and at least 100.");
            return;
        }

        int[] denominations = {300, 200, 100};
        int[] notes = new int[denominations.length];

        // Handle special cases where amount equals one of the denominations
        if (amount == 300) {
            notes[0] = 1;
        } else if (amount == 200) {
            notes[1] = 1;
        } else if (amount == 100) {
            notes[2] = 1;
        } else if (amount < 600) {
            // Handle cases where amount is between 300 and 600
            if (amount == 500) {
                notes[0] = 1; // 300
                notes[1] = 1; // 200
            } else if (amount == 400) {
                notes[1] = 2; // 200 x 2
            }
        } else {
            // Default approach for amounts >= 600
            notes[0] = 1; // one 300-rupee note
            notes[1] = 1; // one 200-rupee note
            notes[2] = 1; // one 100-rupee note

            // Total so far: 300 + 200 + 100 = 600
            int remainingAmount = amount - 600;

            // Distribute the remaining amount using the available denominations
            for (int i = 0; i < denominations.length; i++) {
                while (remainingAmount >= denominations[i]) {
                    notes[i]++;
                    remainingAmount -= denominations[i];
                }
            }
        }

        // Output the results
        System.out.println("300-rupee notes: " + notes[0]);
        System.out.println("200-rupee notes: " + notes[1]);
        System.out.println("100-rupee notes: " + notes[2]);

        // Total number of notes
        int totalNotes = notes[0] + notes[1] + notes[2];
        System.out.println("Total number of notes: " + totalNotes);
    }


    // logic dynamically such that person can be withdraw any amount multiple of 100

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the amount to withdraw (multiple of 100): ");
//        int amount = scanner.nextInt();
//
//        if (amount < 600 || amount % 100 != 0) {
//            System.out.println("Invalid amount. It must be a multiple of 100 and at least 600.");
//            return;
//        }
//
//        int[] denominations = {300, 200, 100};
//        int[] notes = new int[denominations.length];
//
//        // Start by assigning 1 note of each denomination (300, 200, 100)
//        notes[0] = 1; // one 300-rupee note
//        notes[1] = 1; // one 200-rupee note
//        notes[2] = 1; // one 100-rupee note
//
//        // Total so far: 300 + 200 + 100 = 600
//        int remainingAmount = amount - (notes[0] * 300 + notes[1] * 200 + notes[2] * 100);
//
//        // Distribute the remaining amount using the available denominations
//        for (int i = 0; i < denominations.length; i++) {
//            while (remainingAmount >= denominations[i]) {
//                notes[i]++;
//                remainingAmount -= denominations[i];
//            }
//        }
//
//        // Output the results
//        System.out.println("300-rupee notes: " + notes[0]);
//        System.out.println("200-rupee notes: " + notes[1]);
//        System.out.println("100-rupee notes: " + notes[2]);
//
//        // Total number of notes
//        int totalNotes = notes[0] + notes[1] + notes[2];
//        System.out.println("Total number of notes: " + totalNotes);
//    }
}

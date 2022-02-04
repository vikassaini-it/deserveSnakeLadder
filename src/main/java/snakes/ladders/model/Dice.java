package snakes.ladders.model;

import java.util.Scanner;

public class Dice {
    int lowerLimit = 1;
    int upperLimit = 6;
    boolean isCrooked;

    public Dice() {
        Scanner inScanner = new Scanner(System.in);
        System.out.println("Want crooked dice? (N)");
        String readCrooked = inScanner.nextLine();
        if ((readCrooked.startsWith("Y") || readCrooked.startsWith("y")) && !readCrooked.equals("")) {
            isCrooked = true;
            System.out.println("Crooked Dice selected");
        } else {
            isCrooked = false;
            System.out.println("Normal Dice selected");
        }
    }

    public int rollDice() {
        if (isCrooked) {
            return (int) (Math.random() * (upperLimit / 2) + 1) * 2;
        }
        return (int) (Math.random() * (upperLimit - lowerLimit + 1) + lowerLimit);
    }
}

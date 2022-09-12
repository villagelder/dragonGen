package utilities;

import java.util.Random;

public class DiceRoller {

    public static int randInt(int min, int max, int bonus) {
        Random rand = new Random();
        int randomRoll = (rand.nextInt((max - min) + 1) + min) + bonus;
        return randomRoll;
    }

    public static int roll1d2() {
        return rollEm(1, 2)[0];
    }

    public static int roll1d3() {
        return rollEm(1, 3)[0];
    }

    public static int roll1d4() {
        return rollEm(1, 4)[0];
    }

    public static int[] roll2d4() {
        return rollEm(2, 4);
    }

    public static int[] roll3d4() {
        return rollEm(3, 4);
    }

    public static int[] roll4d4() {
        return rollEm(4, 4);
    }

    public static int[] roll5d4() {
        return rollEm(5, 4);
    }

    public static int[] roll6d4() {
        return rollEm(6, 4);
    }

    public static int[] roll7d4() {
        return rollEm(7, 4);
    }

    public static int[] roll8d4() {
        return rollEm(8, 4);
    }

    public static int[] roll9d4() {
        return rollEm(9, 4);
    }

    public static int[] roll10d4() {
        return rollEm(10, 4);
    }

    public static int roll1d6() {
        return rollEm(1, 6)[0];
    }

    public static int[] roll2d6() {
        return rollEm(2, 6);
    }

    public static int[] roll3d6() {
        return rollEm(3, 6);
    }

    public static int[] roll4d6() {
        return rollEm(4, 6);
    }

    public static int[] roll4d6DropLow() {
        return rollEmDropLowest(4, 6);
    }

    public static int[] roll5d6() {
        return rollEm(5, 6);
    }

    public static int[] roll6d6() {
        return rollEm(6, 6);
    }

    public static int[] roll7d6() {
        return rollEm(7, 6);
    }

    public static int[] roll8d6() {
        return rollEm(8, 6);
    }

    public static int[] roll9d6() {
        return rollEm(9, 6);
    }

    public static int[] roll10d6() {
        return rollEm(10, 6);
    }

    public static int roll1d8() {
        return rollEm(1, 8)[0];
    }

    public static int[] roll2d8() {
        return rollEm(2, 8);
    }

    public static int[] roll3d8() {
        return rollEm(3, 8);
    }

    public static int[] roll4d8() {
        return rollEm(4, 8);
    }

    public static int[] roll5d8() {
        return rollEm(5, 8);
    }

    public static int[] roll6d8() {
        return rollEm(6, 8);
    }

    public static int[] roll7d8() {
        return rollEm(7, 8);
    }

    public static int[] roll8d8() {
        return rollEm(8, 8);
    }

    public static int[] roll9d8() {
        return rollEm(9, 8);
    }

    public static int[] roll10d8() {
        return rollEm(10, 8);
    }

    public static int roll1d10() {
        return rollEm(1, 10)[0];
    }

    public static int[] roll2d10() {
        return rollEm(2, 10);
    }

    public static int[] roll3d10() {
        return rollEm(3, 10);
    }

    public static int[] roll4d10() {
        return rollEm(4, 10);
    }

    public static int[] roll5d10() {
        return rollEm(5, 10);
    }

    public static int[] roll6d10() {
        return rollEm(6, 10);
    }

    public static int[] roll7d10() {
        return rollEm(7, 10);
    }

    public static int[] roll8d10() {
        return rollEm(8, 10);
    }

    public static int[] roll9d10() {
        return rollEm(9, 10);
    }

    public static int[] roll10d10() {
        return rollEm(10, 10);
    }

    public static int roll1d12() {
        return rollEm(1, 12)[0];
    }

    public static int[] roll2d12() {
        return rollEm(2, 12);
    }

    public static int[] roll3d12() {
        return rollEm(3, 12);
    }

    public static int[] roll4d12() {
        return rollEm(4, 12);
    }

    public static int[] roll5d12() {
        return rollEm(5, 12);
    }

    public static int[] roll6d12() {
        return rollEm(6, 12);
    }

    public static int[] roll7d12() {
        return rollEm(7, 12);
    }

    public static int[] roll8d12() {
        return rollEm(8, 12);
    }

    public static int[] roll9d12() {
        return rollEm(9, 12);
    }

    public static int[] roll10d12() {
        return rollEm(10, 12);
    }

    public static int roll1d20() {
        return rollEm(1, 20)[0];
    }

    public static int[] roll2d20() {
        return rollEm(2, 20);
    }

    public static int roll1d100() {
        return rollEm(1, 100)[0];
    }

    public static int[] roll2d100() {
        return rollEm(2, 100);
    }

    public static int[] rollEmDropLowest(int numRolls, int typeDice) {
        int min = 1;
        int max = typeDice;
        int lowest = typeDice;
        int totalRoll = 0;
        int[] rolls = new int[numRolls + 1];

        for (int i = 0; i < numRolls; i++) { // roll 1d6 four times
            rolls[i] = randInt(min, max, 0); // store rolls in array
            totalRoll = totalRoll + rolls[i]; // sum the array
        }

        for (int i = 0; i < numRolls; i++) { // cycle through array
            if (rolls[i] < lowest) { // compare each to current lowest
                lowest = rolls[i]; // assign lowest with lower number
            }
        }
        totalRoll = totalRoll - lowest; // subtract lowest from totalRoll
        rolls[numRolls] = totalRoll;

        return rolls; // return totalRoll
    }

    public static int[] rollEm(int numRolls, int typeDice) {
        int min = 1;
        int max = typeDice;
        int totalRoll = 0;
        int[] rolls = new int[numRolls + 1];

        for (int i = 0; i < numRolls; i++) {
            rolls[i] = randInt(min, max, 0);
            totalRoll = totalRoll + rolls[i];
        }

        rolls[numRolls] = totalRoll;

        return rolls; // return totalRoll
    }

    public static int[] roll4d6MethodAll() {
        int[] arr = new int[6];
        int[] rd = null;

        for (int i = 0; i < 6; i++) {
            rd = roll4d6DropLow();
            arr[i] = rd[4];
        }

        return arr;
    }

}
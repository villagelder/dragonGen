package data;

import utilities.DiceRoller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbilityScoreGenerator {

    public static List<Integer> methodStandard4d6() {
        int[] rolls = DiceRoller.roll4d6MethodAll();
        List<Integer> scores = new ArrayList<>();

        for (int r : rolls)
            scores.add(r);

        Collections.sort(scores, Collections.reverseOrder());

        return scores;

    }

    public static List<Integer> methodClassic3d6() {
        List<Integer> scores = new ArrayList<>();
        int n = 0;

        do {
            scores.add(DiceRoller.roll3d6()[3]);
            n++;
        } while (n < 6);


        return scores;
    }

    public static List<Integer> methodStandardArray() {
        return new ArrayList<>(List.of(15, 14, 13, 12, 10, 8));
    }

    private static int sumRolls(int[] rolls) {
        int n = 0;
        for (int r : rolls)
            n = n + r;


        return n;
    }

}

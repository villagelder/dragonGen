package utilities;

import java.util.*;
import java.util.stream.Collectors;

public class Randomizer {

    public static String getRandomElement(List<String> strList) {
        Random rand = new Random();

        return strList.get(rand.nextInt(strList.size()));
    }

    public static String getRandomElement(Set<String> stringSet) {
        Random rand = new Random();

        if (stringSet.isEmpty())
            return null;

        List<String> stringList = new ArrayList<>(stringSet);

        return stringList.get(rand.nextInt(stringList.size()));
    }

    public static <T> Object getRandomObject(List<T> objectList) {
        Random rand = new Random();
        return objectList.get(rand.nextInt(objectList.size()));
    }

    public static char getRandomCharacterFromString(String str) {
        Random r = new Random();
        int i = r.nextInt(str.length());
        return str.charAt(i);
    }

    public static String getNewPCIDToken() {
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String pch = getRandomElement(possibles);
            chList.add(getRandomCharacterFromString(pch));
        }

        return chList.stream()
                .map(String::valueOf).collect(Collectors.joining());
    }



}

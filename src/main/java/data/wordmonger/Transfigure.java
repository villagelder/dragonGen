package data.wordmonger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Background;
import models.IrregularPastTense;

import java.io.IOException;
import java.util.*;

import static managers.ReadFile.readFromFile;


public class Transfigure {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<String> parseAndAbridge(String line) {
        line = line.toLowerCase();
        String[] terms = line.split("[\\s@&.?$+-]+");
        LinkedList<String> wordList = new LinkedList<String>(Arrays.asList(terms));

        try {
            List<String> simpleWords = Arrays.asList("of", "and", "the", "a", "an", "in");
            for (String word : simpleWords) {
                if (wordList.contains(word))
                    wordList.remove(word);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return wordList;
    }

    public static String getPastTenseOfWord(String word) {
        Set<String> irrPastTenseWords = IrregularPasteTenseManager.getAllWordsOfIrrPastTense();

        if (irrPastTenseWords.contains(word)) {
            word = IrregularPasteTenseManager.getIrrPastTenseOfWord(word);

        } else if (word.endsWith("e")) {
            word = word + "d";

        } else if (word.endsWith("y")) {
            word = word.substring(0, word.length() - 1) + "ied";

        } else {
            String longEE = word.substring(word.length() - 3, word.length() - 1);

            if (word.length() > 3 && (longEE.equalsIgnoreCase("ea") || longEE.equalsIgnoreCase("ee"))) {
                word = word + "ed";

            } else {
                word = word + word.substring(word.length() - 1, word.length()) + "ed";
            }
        }
        return word;
    }

    public static String titleCase(String title) {
        title = title.toLowerCase();
        String[] terms = title.split("[\\s@&.?$+-]+");
        LinkedList<String> wordList = new LinkedList<String>(Arrays.asList(terms));
        StringBuilder sb = new StringBuilder();

        for (String word : terms) {
            String w = word.substring(0, 1);
            word = w.toUpperCase() + word.substring(1, word.length());
            sb.append(word + " ");
        }

        return sb.toString().trim();
    }

    public static String getActionMaker(String word) {

        Set<Character> characterSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String c = word.substring(word.length() - 2, word.length() - 1);
        char ch = c.charAt(0);

        if (characterSet.contains(ch) && (
                word.endsWith("t") || word.endsWith("g") || word.endsWith("p") || word.endsWith("b") || word.endsWith("d") || word.endsWith("m") || word.endsWith("n"))) {

            if (word.endsWith("nd") || word.endsWith("st") || word.endsWith("on")) {
                word = word + "er";
            } else {
                word = word + word.substring(word.length() - 1) + "er";
            }
        } else if (word.endsWith("e")) {
            word = word + "r";
        } else if (word.endsWith("ay") || word.endsWith("ey") || word.endsWith("oy")) {
            word = word + "er";
        } else if (word.endsWith("y")) {
            word = word + "ier";
        } else {
            word = word + "er";
        }
        return word;
    }

    public static String getActiveVerb(String verb) {

        if (verb.endsWith("ee")) {
            verb = verb = verb + "ing";
        } else if (verb.endsWith("e")) {
            verb = verb.substring(0, verb.length() - 1) + "ing";
        } else if (verb.endsWith("et")) {
            verb = verb + "ting";
        } else {
            verb = verb + "ing";
        }
        return verb;
    }

    public static String getPluralNoun(String noun) {

        if (noun.endsWith("y")) {
            noun = noun.substring(0, noun.length() - 1) + "ies";
        } else if (noun.endsWith("ch") || noun.endsWith("sh")) {
            noun = noun + "es";
        } else {
            noun = noun + "s";
        }
        return noun;
    }
}

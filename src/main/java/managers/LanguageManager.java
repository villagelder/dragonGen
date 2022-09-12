package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class LanguageManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Language> getAllLanguageObjects() {
        List<Language> languages = null;
        try {
            String jsonArray = readFromFile("languages");
            ObjectMapper objectMapper = new ObjectMapper();
            languages = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languages;
    }

    public static Set<String> getAllLanguagesList() {
        List<Language> languageList = getAllLanguageObjects();
        Set<String> languages = new HashSet<>();

        for (Language lang : languageList)
            languages.add(lang.getLanguage());

        return languages;

    }

    public static Set<Language> getLanguagesBySources(Set<String> sources) {
        List<Language> languageList = getAllLanguageObjects();
        Set<Language> languages = new HashSet<>();

        for (String source : sources) {
            languages.addAll(languageList.stream()
                    .filter(ar -> ar.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return languages;
    }

    public static List<Language> getLanguagesByCategory(List<Language> allLanguages, String category) {
        List<Language> languages = new ArrayList<>();

        languages = allLanguages.stream()
                .filter(lang -> lang.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        return languages;
    }

    public static void assignLanguagesID() {
        List<Language> languageList = getAllLanguageObjects();

        languageList.forEach(lang -> lang.setLanguageID(getNewLanguageID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(languageList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "languages.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Language> getLanguagesBySpeakers(List<Language> allLanguages, String speakers) {
        List<Language> languages = new ArrayList<>();
        speakers = speakers.toLowerCase();

        switch (speakers) {
            case "orc":
                speakers = "orcs";
                break;
            case "human":
                speakers = "humans";
                break;
            case "dwarf":
                speakers = "dwarves";
                break;
            case "elf":
                speakers = "elves";
                break;
            case "giant":
                speakers = "giants";
                break;
            case "ogre":
                speakers = "ogres";
                break;
            case "half-orc":
                speakers = "orcs";
                break;
            case "half-elf":
                speakers = "elves";
                break;
            case "drow elf":
                speakers = "drow";
                break;
            case "gnome":
                speakers = "gnomes";
                break;
            case "halfling":
                speakers = "halflings";
                break;
            case "demon":
                speakers = "demons";
                break;
            case "celestial":
                speakers = "celestials";
                break;
            case "dragon":
                speakers = "dragons";
                break;
            case "mind flayer":
                speakers = "mind flayers";
                break;
            case "beholder":
                speakers = "beholders";
                break;
            case "illithid":
                speakers = "mind flayers";
                break;
            case "devil":
                speakers = "devils";
                break;
            case "elemental":
                speakers = "elementals";
                break;
            case "fey":
                speakers = "fey creatures";
                break;
            case "drow":
                speakers = "drow";
                break;
            case "druid":
                speakers = "druids";
                break;
            default:
                break;
        }

        String finalSpeakers = speakers;
        return allLanguages.stream()
                .filter(language -> language.getSpeakers().contains(finalSpeakers))
                .collect(Collectors.toList());

    }
    public static void saveLanguages(List<Language> languageList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(languageList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "languages.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveLanguage(Language language, String userName) {

        boolean isNewArmor = false;

        if (language.getLanguageID() == null) {
            language.setLanguageID(getNewLanguageID());
            isNewArmor = true;
        }

        List<Language> languageList = getAllLanguageObjects();

        if (languageList == null)
            languageList = new ArrayList<>();

        //overwrite
        Language oldLang = null;
        if (!isNewArmor) {
            if (languageList.stream().anyMatch(lng -> lng.getLanguageID().equals(language.getLanguageID()))) {
                oldLang = languageList.stream()
                        .filter(lang -> lang.getLanguageID().equals(language.getLanguageID()))
                        .findFirst().get();

                if (oldLang.getAuthor().equals(userName))
                    languageList.remove(oldLang);
            }
        }

        languageList.add(language);
        saveLanguages(languageList);
    }

    private static String getNewLanguageID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String languageID = "";

        List<Language> languageList = getAllLanguageObjects();
        Set<String> ids = languageList.stream()
                .map(Language::getLanguageID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            languageID = "LNG-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(languageID));

        return languageID;

    }

    public static void deleteLanguageByID(String languageID, String userName) {
        List<Language> languageList = getAllLanguageObjects();
        Language language = null;

        if (languageList.stream().anyMatch(lng -> lng.getLanguageID().equals(languageID))) {
            language = languageList.stream().filter(lang -> lang.getLanguageID().equals(languageID))
                    .findFirst().get();

            if (language.getAuthor().equals(userName)) {
                languageList.remove(language);
                saveLanguages(languageList);
            }
        }

        return;
    }
}

package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Feat;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class FeatsManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Feat> getAllFeatObjects() {
        List<Feat> feats = null;
        try {
            String jsonArray = readFromFile("feats");
            ObjectMapper objectMapper = new ObjectMapper();
            feats = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return feats;
    }

    public static Feat getFeatByName(String featName) {
        List<Feat> featList = getAllFeatObjects();
        Feat feat = null;

        if (featList.stream().anyMatch(ft -> ft.getName().equalsIgnoreCase(featName)))
            feat = featList.stream()
                    .filter(f -> f.getName().equalsIgnoreCase(featName))
                    .findFirst().get();


        return feat;

    }

    public static Set<String> getAllFeatNames() {
        List<Feat> featList = getAllFeatObjects();
        return featList.stream()
                .map(f -> f.getName())
                .collect(Collectors.toSet());

    }

    public static Set<Feat> getFeatsBySources(Set<String> sources) {
        List<Feat> featList = getAllFeatObjects();
        Set<Feat> feats = new HashSet<>();

        for (String source : sources) {
            feats.addAll(featList.stream()
                    .filter(feat -> feat.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return feats;
    }

    public static void saveFeats(List<Feat> featList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(featList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "feats.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveFeat(Feat feat, String userName) {

        boolean isNewFeat = false;

        if (feat.getFeatID() == null) {
            feat.setFeatID(getNewFeatID());
            isNewFeat = true;
        }

        List<Feat> featList = getAllFeatObjects();

        if (featList == null)
            featList = new ArrayList<>();

        //overwrite
        Feat oldFeat = null;
        if (!isNewFeat) {
            if (featList.stream().anyMatch(ft -> ft.getFeatID().equals(feat.getFeatID()))) {
                oldFeat = featList.stream()
                        .filter(fx -> fx.getFeatID().equals(feat.getFeatID()))
                        .findFirst().get();

                if (oldFeat.getAuthor().equals(userName))
                    featList.remove(oldFeat);
            }
        }

        featList.add(feat);
        saveFeats(featList);
    }

    private static String getNewFeatID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String featID = "";

        List<Feat> featList = getAllFeatObjects();
        Set<String> ids = featList.stream()
                .map(Feat::getFeatID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            featID = "FT-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(featID));

        return featID;

    }

    public static void deleteFeatByID(String featID, String userName) {
        List<Feat> featList = getAllFeatObjects();
        Feat feat = null;

        if (featList.stream().anyMatch(ft -> ft.getFeatID().equals(featID))) {
            feat = featList.stream().filter(fx -> fx.getFeatID().equals(featID))
                    .findFirst().get();

            if (feat.getAuthor().equals(userName)) {
                featList.remove(feat);
                saveFeats(featList);
            }
        }
        return;
    }

    public static String refineElementalAdeptFeat(Set<String> feats) {
        Set<String> damageTypes = new HashSet<>(Arrays.asList("Cold", "Fire", "Acid", "Lightning", "Thunder"));
        String feat = null;
        do {
            String damage = Randomizer.getRandomElement(damageTypes);
            feat = "Elemental Adept (" + damage + ")";
        } while (feats.contains(feat));
        return feat;
    }

    public static Set<String> refineLinguistFeat(Set<String> languages) {
        Set<String> languageList = LanguageManager.getAllLanguagesList();
        for (int i = 0; i < 3; i++) {
            String lang = null;
            do {
                lang = Randomizer.getRandomElement(languageList);
            } while (languages.contains(lang));
            languages.add(lang);
        }
        return languages;
    }


}

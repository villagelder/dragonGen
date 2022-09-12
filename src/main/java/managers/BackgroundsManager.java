package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.DiceRoller;
import models.Background;
import models.CharacterClass;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class BackgroundsManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Background> getAllBackgroundObjects() {
        List<Background> backgroundList = null;
        try {
            String jsonArray = readFromFile("backgrounds");
            ObjectMapper objectMapper = new ObjectMapper();
            backgroundList = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return backgroundList;
    }

    public static Background getBackgroundByName(String background) {
        List<Background> backgroundList = getAllBackgroundObjects();

        return backgroundList.stream()
                .filter(bo -> bo.getBackground().equalsIgnoreCase(background))
                .findFirst().get();

    }

    public static Set<Background> getBackgroundsBySources(Set<String> sources){
        List<Background> backgroundList = getAllBackgroundObjects();
        Set<Background> backgrounds = new HashSet<>();

        for (String source : sources) {
            backgrounds.addAll(backgroundList.stream()
                    .filter(bk -> bk.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return backgrounds;

    }

    public static Background getRandomBackground() {
        List<Background> backgroundList = getAllBackgroundObjects();

        return (Background) Randomizer.getRandomObject(backgroundList);
    }

    public static Background getRandomBackgroundWeighted(CharacterClass chClass) {
        Set<String> favBackgrounds = chClass.getFavoriteBackgrounds();
        List<Background> allBackgrounds = getAllBackgroundObjects();
        String background;

        if (DiceRoller.roll2d6()[2] > 5) {
            background = Randomizer.getRandomElement(favBackgrounds);
        } else {
            Background bk = (Background) Randomizer.getRandomObject(allBackgrounds);
            background = bk.getBackground();
        }
        return getBackgroundByName(background);

    }

    private static String getNewBackgroundID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String backgroundID = "";

        List<Background> backgroundList = getAllBackgroundObjects();
        Set<String> ids = backgroundList.stream()
                .map(Background::getBackgroundID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            backgroundID = "BK-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(backgroundID));

        return backgroundID;

    }

    public static void saveBackgrounds(List<Background> backgroundList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(backgroundList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "backgrounds.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveBackground(Background background, String username) {

        boolean isNewBackground = false;

        if (background.getBackgroundID() == null) {
            background.setBackgroundID(getNewBackgroundID());
            isNewBackground = true;
        }

        List<Background> backgroundList = getAllBackgroundObjects();

        if (backgroundList == null)
            backgroundList = new ArrayList<>();

        //overwrite
        Background oldBackground = null;
        if (!isNewBackground) {
            if (backgroundList.stream().anyMatch(bk -> bk.getBackgroundID().equals(background.getBackgroundID()))) {
                oldBackground = backgroundList.stream()
                        .filter(bkd -> bkd.getBackgroundID().equals(background.getBackgroundID()))
                        .findFirst().get();

                if (oldBackground.getAuthor().equalsIgnoreCase(username))
                    backgroundList.remove(oldBackground);
            }
        }

        backgroundList.add(background);

        saveBackgrounds(backgroundList);

    }

    public static void deleteBackgroundByID(String backgroundID, String username) {
        List<Background> backgroundList = getAllBackgroundObjects();
        Background background = null;

        if (backgroundList.stream().anyMatch(bk -> bk.getBackgroundID().equals(backgroundID))) {
            background = backgroundList.stream().filter(spl -> spl.getBackgroundID().equals(backgroundID))
                    .findFirst().get();

            if (background.getAuthor().equals(username)) {
                backgroundList.remove(background);

                saveBackgrounds(backgroundList);
            }
        }

        return;
    }

    public static void assignBackgroundsID() {
        List<Background> backgroundList = getAllBackgroundObjects();

        backgroundList.forEach(background -> background.setBackgroundID(getNewBackgroundID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(backgroundList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "backgrounds.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

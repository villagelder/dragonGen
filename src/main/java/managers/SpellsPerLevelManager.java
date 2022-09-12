package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.Skill;
import models.SpellsPerLevel;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class SpellsPerLevelManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<SpellsPerLevel> getAllSpellsPerLevelObjects() {
        List<SpellsPerLevel> spellsPerLevelList = null;
        try {
            String jsonArray = readFromFile("spellsPerLevel");
            ObjectMapper objectMapper = new ObjectMapper();
            spellsPerLevelList = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spellsPerLevelList;
    }

    public static List<SpellsPerLevel> getAllSpellsPerLevelByClass(List<SpellsPerLevel> spellsPerLevelList, String className) {

        return spellsPerLevelList.stream()
                .filter(spl -> spl.getClassName().equalsIgnoreCase(className))
                .sorted(Comparator.comparing(SpellsPerLevel::getClassLevel))
                .collect(Collectors.toList());

    }

    public static SpellsPerLevel getSpellsPerLevelByClassAndLevel(String className, int classLevel) {

        List<SpellsPerLevel> spellsPerLevelList = SpellsPerLevelManager.getAllSpellsPerLevelObjects();

        return spellsPerLevelList.stream()
                .filter(spl -> spl.getClassName().equalsIgnoreCase(className))
                .filter(spl -> spl.getClassLevel() == classLevel)
                .findAny().get();

    }

    public static void saveSpellsPerLevelList(List<SpellsPerLevel> spellsPerLevelList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(spellsPerLevelList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "spellsPerLevel.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveSpellsPerLevel(SpellsPerLevel spellsPerLevel, String userName) {

        boolean isNewSpellsPerLevel = false;

        if (spellsPerLevel.getSpellsPerLevelID() == null) {
            spellsPerLevel.setSpellsPerLevelID(getNewSpellsPerLevelID());
            isNewSpellsPerLevel = true;
        }

        List<SpellsPerLevel> spellsPerLevelList = getAllSpellsPerLevelObjects();

        if (spellsPerLevelList == null)
            spellsPerLevelList = new ArrayList<>();

        //overwrite
        SpellsPerLevel oldSpellsPerLevel = null;
        if (!isNewSpellsPerLevel) {
            if (spellsPerLevelList.stream().anyMatch(spl -> spl.getSpellsPerLevelID().equals(spellsPerLevel.getSpellsPerLevelID()))) {
                oldSpellsPerLevel = spellsPerLevelList.stream()
                        .filter(sppl -> sppl.getSpellsPerLevelID().equals(spellsPerLevel.getSpellsPerLevelID()))
                        .findFirst().get();

                if (oldSpellsPerLevel.getAuthor().equals(userName))
                    spellsPerLevelList.remove(oldSpellsPerLevel);
            }
        }

        spellsPerLevelList.add(spellsPerLevel);
        saveSpellsPerLevelList(spellsPerLevelList);
    }

    private static String getNewSpellsPerLevelID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String spellsPerLevelID = "";

        List<SpellsPerLevel> spellsPerLevelList = getAllSpellsPerLevelObjects();
        Set<String> ids = spellsPerLevelList.stream()
                .map(SpellsPerLevel::getSpellsPerLevelID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }
            spellsPerLevelID = "SPL-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(spellsPerLevelID));

        return spellsPerLevelID;

    }
}

package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import models.*;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class SpellManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Spell> getAllSpellObjects() {
        List<Spell> spells = null;
        try {
            String jsonArray = readFromFile("spells");
            ObjectMapper objectMapper = new ObjectMapper();
            spells = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spells;
    }

    public static Spell getSpellByID(String spellID) {
        List<Spell> spellList = getAllSpellObjects();

        if (spellList.stream().anyMatch(sp -> sp.getSpellID().equals(spellID)))
            return spellList.stream().filter(spell -> spell.getSpellID().equals(spellID))
                    .findFirst().get();

        return null;
    }

    public static Spell getSpellByName(String spellName) {
        List<Spell> spellList = getAllSpellObjects();
        Spell spell = null;

        if (spellList.stream().anyMatch(sp -> sp.getSpellName().equals(spellName)))
            spell = spellList.stream().filter(sp -> sp.getSpellName().equals(spellName))
                    .findFirst().get();

        return spell;
    }

    public static void deleteSpellByID(String spellID, String userID) {
        List<Spell> spellList = getAllSpellObjects();
        Spell spell = null;

        if (spellList.stream().anyMatch(sp -> sp.getSpellID().equals(spellID))) {
            spell = spellList.stream().filter(spl -> spl.getSpellID().equals(spellID))
                    .findFirst().get();

            if (spell.getAuthor().equals(userID)) {
                spellList.remove(spell);

                saveSpells(spellList);
            }
        }

        return;
    }

    public static void saveSpells(List<Spell> spellList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(spellList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "spells.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveSpell(Spell newSpell, String username) {

        boolean isNewSpell = false;

        if (newSpell.getSpellID() == null) {
            newSpell.setSpellID(SpellManager.getNewSpellID());
            isNewSpell = true;
        }

        List<Spell> spellList = getAllSpellObjects();

        if (spellList == null)
            spellList = new ArrayList<>();

        //overwrite
        Spell oldSpell = null;
        if (!isNewSpell) {
            if (spellList.stream().anyMatch(sp -> sp.getSpellID().equals(newSpell.getSpellID()))) {
                oldSpell = spellList.stream()
                        .filter(spl -> spl.getSpellID().equals(spl.getSpellID()))
                        .findFirst().get();

                if (oldSpell.getAuthor().equalsIgnoreCase(username))
                    spellList.remove(oldSpell);
            }
        }

        spellList.add(newSpell);

        saveSpells(spellList);

    }

    public static void assignSpellsID() {
        List<Spell> spellList = getAllSpellObjects();

        spellList.forEach(spell -> spell.setSpellID(getNewSpellID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(spellList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "spells.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getNewSpellID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String spellID = "";

        List<Spell> spellList = getAllSpellObjects();
        Set<String> ids = spellList.stream()
                .map(Spell::getSpellID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }
            spellID = "SP-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(spellID));

        return spellID;

    }

    //classname and school can be null, spellLevel min-max range
    //Cantrips = level 0
    public static List<Spell> getSpellsByClassSchoolAndLevels(String className, String school, int spellLevelMin, int spellLevelMax) {
        List<Spell> allSpells = getAllSpellObjects();
        List<Spell> spellList = new ArrayList<>();

        if (className != null)
            spellList = allSpells.stream()
                    .filter(sp -> sp.getSpellcasters().contains(className.toLowerCase()))
                    .collect(Collectors.toList());

        if (school != null) {
            spellList = spellList.stream()
                    .filter(sp -> sp.getSchool().equalsIgnoreCase(school.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return spellList.stream()
                .filter(s -> s.getSpellLevel() >= spellLevelMin)
                .filter(t -> t.getSpellLevel() <= spellLevelMax)
                .collect(Collectors.toList());

    }

    public static Set<Spell> getSpellsBySources(Set<String> sources) {
        List<Spell> spellList = getAllSpellObjects();
        Set<Spell> spells = new HashSet<>();

        for (String source : sources) {
            spells.addAll(spellList.stream()
                    .filter(sp -> sp.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return spells;
    }
}

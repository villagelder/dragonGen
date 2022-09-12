package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Archetype;
import models.Spell;
import models.User;
import models.WeaponProficiency;
import org.apache.commons.lang3.arch.Processor;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class ArchetypesManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Archetype> getAllArchetypeObjects() {
        List<Archetype> archetypes = null;
        try {
            String jsonArray = readFromFile("archetypes");
            ObjectMapper objectMapper = new ObjectMapper();
            archetypes = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return archetypes;
    }

    public static Set<Archetype> getArchetypesBySources(Set<String> sourceList) {
        List<Archetype> archetypesList = getAllArchetypeObjects();
        Set<Archetype> archetypes = new HashSet<>();

        for (String source : sourceList) {
            archetypes.addAll(archetypesList.stream()
                    .filter(archetype -> archetype.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }
        return archetypes;
    }

    public static List<Archetype> getAllArchetypesByClassName(String className) {
        List<Archetype> archetypeList = getAllArchetypeObjects();

        List<Archetype> filteredList = archetypeList.stream()
                .filter(archetype -> archetype.getClassName().equalsIgnoreCase(className))
                .sorted(Comparator.comparing(Archetype::getArchetypeName))
                .collect(Collectors.toList());

        return filteredList;
    }

    public static List<String> getSimpleArchetypesByClassName(String className) {
        List<Archetype> archetypeList = getAllArchetypeObjects();

        List<String> filteredList = archetypeList.stream()
                .filter(archetype -> archetype.getClassName().equalsIgnoreCase(className))
                .sorted(Comparator.comparing(Archetype::getArchetypeName))
                .map(a -> a.getArchetypeName())
                .collect(Collectors.toList());

        return filteredList;
    }

    public static Archetype getArchetypeByID(String archetypeID) {
        List<Archetype> archetypeList = getAllArchetypeObjects();

        if (archetypeList.stream().anyMatch(ar -> ar.getArchetypeID().equals(archetypeID)))
            return archetypeList.stream()
                    .filter(arch -> arch.getArchetypeID().equals(archetypeID))
                    .findFirst().get();

        return null;
    }

    public static void assignArchetypesID() {
        List<Archetype> archetypeList = getAllArchetypeObjects();

        archetypeList.forEach(archetype -> archetype.setArchetypeID(getNewArchetypeID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(archetypeList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "archetypes.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getNewArchetypeID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String archetypeID = "";

        List<Archetype> archetypeList = getAllArchetypeObjects();
        Set<String> ids = archetypeList.stream()
                .map(Archetype::getArchetypeID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            archetypeID = "ART-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(archetypeID));


        return archetypeID;

    }

    public static void saveArchetypes(List<Archetype> archetypeList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(archetypeList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "archetypes.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveArchetype(Archetype newArchetype, String userName) {

        boolean isNewArchetype = false;

        if (newArchetype.getArchetypeID() == null) {
            newArchetype.setArchetypeID(getNewArchetypeID());
            isNewArchetype = true;
        }

        List<Archetype> archetypeList = getAllArchetypeObjects();

        if (archetypeList == null)
            archetypeList = new ArrayList<>();

        //overwrite
        Archetype oldArchetype = null;
        if (!isNewArchetype) {
            if (archetypeList.stream().anyMatch(ar -> ar.getArchetypeID().equals(newArchetype.getArchetypeID()))) {
                oldArchetype = archetypeList.stream()
                        .filter(arch -> arch.getArchetypeID().equals(newArchetype.getArchetypeID()))
                        .findFirst().get();

                if (oldArchetype.getAuthor().equals(userName))
                    archetypeList.remove(oldArchetype);
            }
        }

        archetypeList.add(newArchetype);
        saveArchetypes(archetypeList);
    }

    public static void deleteArchetypeByID(String archetypeID, String username) {
        List<Archetype> archetypeList = getAllArchetypeObjects();
        Archetype archetype = null;

        if (archetypeList.stream().anyMatch(ar -> ar.getArchetypeID().equals(archetypeID))) {
            archetype = archetypeList.stream().filter(arch -> arch.getArchetypeID().equals(archetypeID))
                    .findFirst().get();

            if (archetype.getAuthor().equals(username)) {
                archetypeList.remove(archetype);
                saveArchetypes(archetypeList);
            }
        }

        return;
    }
}

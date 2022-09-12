package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.Feat;
import models.Personality;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class PersonalityManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Personality> getAllPersonalityObjects() {

        List<Personality> personalities = new ArrayList<>();
        try {
            String jsonArray = readFromFile("personalities");
            ObjectMapper objectMapper = new ObjectMapper();
            personalities = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personalities;
    }

    public static Personality getPersonalityByBackground(String background) {
        List<Personality> personalityList = getAllPersonalityObjects();
        return personalityList.stream()
                .filter(p -> p.getBackground().equalsIgnoreCase(background))
                .findFirst()
                .orElse(null);
    }

    public static void savePersonalities(List<Personality> personalityList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personalityList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "personalities.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void savePersonality(Personality personality, String userName) {

        boolean isNewPers = false;

        if (personality.getPersonalityID() == null) {
            personality.setPersonalityID(getNewPersonalityID());
            isNewPers = true;
        }

        List<Personality> personalityList = getAllPersonalityObjects();

        if (personalityList == null)
            personalityList = new ArrayList<>();

        //overwrite
        Personality oldPersonality = null;
        if (!isNewPers) {
            if (personalityList.stream().anyMatch(pr -> pr.getPersonalityID().equals(personality.getPersonalityID()))) {
                oldPersonality = personalityList.stream()
                        .filter(per -> per.getPersonalityID().equals(personality.getPersonalityID()))
                        .findFirst().get();

                if (oldPersonality.getAuthor().equals(userName))
                    personalityList.remove(oldPersonality);
            }
        }

        personalityList.add(personality);
        savePersonalities(personalityList);
    }

    private static String getNewPersonalityID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String personalityID = "";

        List<Personality> personalityList = getAllPersonalityObjects();
        Set<String> ids = personalityList.stream()
                .map(Personality::getPersonalityID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            personalityID = "PE-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(personalityID));

        return personalityID;

    }

    public static void deletePersonalityByID(String personalityID, String userName) {
        List<Personality> personalityList = getAllPersonalityObjects();
        Personality personality = null;

        if (personalityList.stream().anyMatch(pr -> pr.getPersonalityID().equals(personalityID))) {
            personality = personalityList.stream().filter(per -> per.getPersonalityID().equals(personalityID))
                    .findFirst().get();

            if (personality.getAuthor().equals(userName)) {
                personalityList.remove(personality);
                savePersonalities(personalityList);
            }
        }

        return;
    }

    public static Set<Personality> getPersonalitiesBySources(Set<String> sources) {
        List<Personality> personalityList = getAllPersonalityObjects();
        Set<Personality> personalities = new HashSet<>();

        for (String source : sources) {
            personalities.addAll(personalityList.stream()
                    .filter(pers -> pers.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return personalities;
    }

}

package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.Feat;
import models.Race;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class RacesManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Race> getAllRaceObjects() {
        List<Race> races = null;
        try {
            String jsonArray = readFromFile("races");
            ObjectMapper objectMapper = new ObjectMapper();
            races = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return races;
    }

    public static Race getRaceBySubrace(String race, String srace) {
        List<Race> raceList = getAllRaceObjects();

        Race fullRace = raceList.stream()
                .filter(r -> r.getRaceName().equalsIgnoreCase(race))
                .filter((s -> s.getSubrace().equalsIgnoreCase(srace)))
                .findFirst()
                .get();

        return fullRace;
    }

    public static List<Race> getSubracesByRace(String race) {
        List<Race> raceList = getAllRaceObjects();
        String finalRace = race;

        List<Race> races = raceList.stream()
                .filter(r -> r.getRaceName().equalsIgnoreCase(finalRace))
                .filter(r -> !r.getSubrace().equalsIgnoreCase("base"))
                .collect(Collectors.toList());

        return races;

    }

    public static List<Race> getCompleteRaces() {
        List<Race> raceList = getAllRaceObjects();

        List<Race> races = raceList.stream()
                .filter(r -> !r.getSubrace().equalsIgnoreCase("base"))
                .collect(Collectors.toList());

        return races;
    }

    public static Set<String> getSimpleRacesList() {
        List<Race> raceObjects = getAllRaceObjects();
        Set<String> raceList = new HashSet<>();

        for (Race r : raceObjects)
            raceList.add(r.getRaceName());

        return raceList;

    }

    public static Set<String> getSimpleSubracesList(String race) {

        List<Race> raceList = getAllRaceObjects();
        String finalRace = race;
        Set<String> subraceList = new HashSet<>();

        List<Race> races = raceList.stream()
                .filter(r -> r.getRaceName().equalsIgnoreCase(finalRace))
                .filter(r -> !r.getSubrace().equalsIgnoreCase("base"))
                .collect(Collectors.toList());

        for (Race r : races)
            subraceList.add(r.getSubrace());

        return subraceList;

    }

    public static Race getRandomRace(String race) {
        Race randomRace;
        List<Race> raceList = RacesManager.getCompleteRaces();
        Random rand = new Random();

        //check for specific race request
        for (Race rc : raceList)
            if ((rc.getSubrace() + " " + rc.getRaceName()).equalsIgnoreCase(race))
                return rc;

        //if base race, filter to only subraces of race
        if (race != null) {

            // filter raceList by base race
            raceList = raceList.stream()
                    .filter(r -> r.getRaceName().toLowerCase().equalsIgnoreCase(race))
                    .collect(Collectors.toList());


        }
        //if race is null, use entire list
        //randomize from list
        randomRace = raceList.get(rand.nextInt(raceList.size()));

        return randomRace;

    }

    public static Set<Race> getRacesBySources(Set<String> sources) {
        List<Race> raceList = getAllRaceObjects();
        Set<Race> races = new HashSet<>();

        for (String source : sources) {
            races.addAll(raceList.stream()
                    .filter(rc -> rc.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return races;
    }

    public static void saveRaces(List<Race> raceList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(raceList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "races.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveRace(Race race, String userName) {

        boolean isNewRace = false;

        if (race.getRaceID() == null) {
            race.setRaceID(getNewRaceID());
            isNewRace = true;
        }

        List<Race> raceList = getAllRaceObjects();

        if (raceList == null)
            raceList = new ArrayList<>();

        //overwrite
        Race oldRace = null;
        if (!isNewRace) {
            if (raceList.stream().anyMatch(rc -> rc.getRaceID().equals(race.getRaceID()))) {
                oldRace = raceList.stream()
                        .filter(arm -> arm.getRaceID().equals(race.getRaceID()))
                        .findFirst().get();

                if (oldRace.getAuthor().equals(userName))
                    raceList.remove(oldRace);
            }
        }

        raceList.add(race);
        saveRaces(raceList);
    }

    private static String getNewRaceID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String raceID = "";

        List<Race> raceList = getAllRaceObjects();
        Set<String> ids = raceList.stream()
                .map(Race::getRaceID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            raceID = "RC-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(raceID));

        return raceID;

    }

    public static void deleteRaceByID(String raceID, String userName) {
        List<Race> raceList = getAllRaceObjects();
        Race race = null;

        if (raceList.stream().anyMatch(ra -> ra.getRaceID().equals(raceID))) {
            race = raceList.stream().filter(rc -> rc.getRaceID().equals(raceID))
                    .findFirst().get();

            if (race.getAuthor().equals(userName)) {
                raceList.remove(race);
                saveRaces(raceList);
            }
        }

        return;
    }

}

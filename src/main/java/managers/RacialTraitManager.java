package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.RacialTrait;
import models.Skill;
import utilities.Randomizer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class RacialTraitManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<RacialTrait> getAllRacialTraitObjects() {
        List<RacialTrait> racialTraits = null;
        try {
            String jsonArray = readFromFile("racialTraits");
            ObjectMapper objectMapper = new ObjectMapper();
            racialTraits = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return racialTraits;
    }

    public static RacialTrait getRacialTraitByName(List<RacialTrait> rtList, String racialTrait) {
        return rtList.stream()
                .filter(rt -> rt.getTraitName().equalsIgnoreCase(racialTrait))
                .findFirst()
                .get();

    }

    public static void saveRacialTraits(List<RacialTrait> racialTraitList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(racialTraitList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "racialTs.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveRacialTrait(RacialTrait racialTrait, String userName) {

        boolean isNewRacialTrait = false;

        if (racialTrait.getTraitID() == null) {
            racialTrait.setTraitID(getNewRacialTraitID());
            isNewRacialTrait = true;
        }

        List<RacialTrait> racialTraitList = getAllRacialTraitObjects();

        if (racialTraitList == null)
            racialTraitList = new ArrayList<>();

        //overwrite
        RacialTrait oldRacialTrait = null;

        if (!isNewRacialTrait) {
            if (racialTraitList.stream().anyMatch(rt -> rt.getTraitID().equals(racialTrait.getTraitID()))) {
                oldRacialTrait = racialTraitList.stream()
                        .filter(rct -> rct.getTraitID().equals(racialTrait.getTraitID()))
                        .findFirst().get();

                if (oldRacialTrait.getAuthor().equals(userName))
                    racialTraitList.remove(oldRacialTrait);
            }
        }

        racialTraitList.add(racialTrait);
        saveRacialTraits(racialTraitList);
    }

    private static String getNewRacialTraitID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String traitID = "";

        List<RacialTrait> racialTraitList = getAllRacialTraitObjects();
        Set<String> ids = racialTraitList.stream()
                .map(RacialTrait::getTraitID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }
            traitID = "RCT-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(traitID));

        return traitID;

    }

    public static void deleteRacialTraitByID(String racialTraitID, String userName) {
        List<RacialTrait> racialTraitList = getAllRacialTraitObjects();
        RacialTrait racialTrait = null;

        if (racialTraitList.stream().anyMatch(rt -> rt.getTraitID().equals(racialTraitID))) {
            racialTrait = racialTraitList.stream().filter(rct -> rct.getTraitID().equals(racialTraitID))
                    .findFirst().get();

            if (racialTrait.getAuthor().equals(userName)) {
                racialTraitList.remove(racialTrait);
                saveRacialTraits(racialTraitList);
            }
        }

        return;
    }

}

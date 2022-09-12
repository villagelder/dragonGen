package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Archetype;
import models.Armor;
import models.CharacterClass;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class ArmorManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Armor> getAllArmorObjects() {
        List<Armor> armors = null;
        try {
            String jsonArray = readFromFile("armors");
            ObjectMapper objectMapper = new ObjectMapper();
            armors = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return armors;
    }

    public static Set<Armor> getArmorsBySources(Set<String> sources) {
        List<Armor> armorList = getAllArmorObjects();
        Set<Armor> armors = new HashSet<>();

        for (String source : sources) {
            armors.addAll(armorList.stream()
                    .filter(ar -> ar.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return armors;
    }

    public static List<Armor> getArmorsByProficiency(String category) {
        List<Armor> armors = getAllArmorObjects();
        List<Armor> armorList = new ArrayList<>();

        for (Armor a : armors) {
            if (a.getProficiency().equalsIgnoreCase(category)) {
                armorList.add(a);
            }

        }
        return armorList;
    }

    public static void assignArmorsID() {
        List<Armor> armorList = getAllArmorObjects();

        armorList.forEach(armor -> armor.setArmorID(getNewArmorID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(armorList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "armors.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Set<String> getAllArmorNames() {
        List<Armor> armorList = getAllArmorObjects();

        return armorList.stream()
                .map(armor -> armor.getArmorName())
                .collect(Collectors.toSet());
    }

    public static Armor getArmorByName(String armorName) {
        List<Armor> armorList = getAllArmorObjects();

        if (!armorList.stream().anyMatch(armor -> armor.getArmorName().equalsIgnoreCase(armorName))) {
            return null;
        }

        return armorList.stream()
                .filter(armor -> armor.getArmorName().equalsIgnoreCase(armorName))
                .findFirst().get();
    }

    public static void saveArmors(List<Armor> armorList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(armorList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "armors.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveArmor(Armor armor, String userName) {

        boolean isNewArmor = false;

        if (armor.getArmorID() == null) {
            armor.setArmorID(getNewArmorID());
            isNewArmor = true;
        }

        List<Armor> armorList = getAllArmorObjects();

        if (armorList == null)
            armorList = new ArrayList<>();

        //overwrite
        Armor oldArmor = null;
        if (!isNewArmor) {
            if (armorList.stream().anyMatch(ar -> ar.getArmorID().equals(armor.getArmorID()))) {
                oldArmor = armorList.stream()
                        .filter(arm -> arm.getArmorID().equals(armor.getArmorID()))
                        .findFirst().get();

                if (oldArmor.getAuthor().equals(userName))
                    armorList.remove(oldArmor);
            }
        }

        armorList.add(armor);
        saveArmors(armorList);
    }

    private static String getNewArmorID() {


        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String armorID = "";

        List<Armor> armorList = getAllArmorObjects();
        Set<String> ids = armorList.stream()
                .map(Armor::getArmorID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            armorID = "ARM-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(armorID));

        return armorID;

    }

    public static void deleteArmorByID(String armorID, String userName) {
        List<Armor> armorList = getAllArmorObjects();
        Armor armor = null;

        if (armorList.stream().anyMatch(ar -> ar.getArmorID().equals(armorID))) {
            armor = armorList.stream().filter(arch -> arch.getArmorID().equals(armorID))
                    .findFirst().get();

            if (armor.getAuthor().equals(userName)) {
                armorList.remove(armor);
                saveArmors(armorList);
            }
        }

        return;
    }

}

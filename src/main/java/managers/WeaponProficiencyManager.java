package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.Weapon;
import models.WeaponProficiency;
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

public class WeaponProficiencyManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<WeaponProficiency> getAllWeaponProficiencyObjects() {
        List<WeaponProficiency> weaponProficiencies = null;
        try {
            String jsonArray = readFromFile("wpnproficiencies");
            ObjectMapper objectMapper = new ObjectMapper();
            weaponProficiencies = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weaponProficiencies;
    }

    public static WeaponProficiency getWeaponProficiencyByName(String wpnProfName) {
        List<WeaponProficiency> wpnProfList = getAllWeaponProficiencyObjects();
        WeaponProficiency weaponProficiency = wpnProfList.stream()
                .filter(wp -> wp.getName().equalsIgnoreCase(wpnProfName))
                .findFirst().get();

        return weaponProficiency;
    }

    public static Set<String> getWeaponProficiencies() {
        List<WeaponProficiency> weaponProfObjects = getAllWeaponProficiencyObjects();

        return weaponProfObjects.stream()
                .map(WeaponProficiency::getName)
                .collect(Collectors.toSet());
    }

    public static Set<String> getWeaponsInProficiency(String wpnProf) {
        WeaponProficiency wp = getWeaponProficiencyByName(wpnProf);
        return wp.getWeapons().stream().collect(Collectors.toSet());
    }

    public static void saveWeaponProficiencies(List<WeaponProficiency> weaponProficiencyList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weaponProficiencyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "wpnProficiencies.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveWeaponProficiency(WeaponProficiency weaponProficiency, String userName) {

        boolean isNewWpnProf = false;

        if (weaponProficiency.getWeaponProfID() == null) {
            weaponProficiency.setWeaponProfID(getNewWpnProfID());
            isNewWpnProf = true;
        }

        List<WeaponProficiency> weaponProficiencyList = getAllWeaponProficiencyObjects();

        if (weaponProficiencyList == null)
            weaponProficiencyList = new ArrayList<>();

        //overwrite
        WeaponProficiency oldWeaponProf = null;
        if (!isNewWpnProf) {
            if (weaponProficiencyList.stream().anyMatch(wp -> wp.getWeaponProfID().equals(weaponProficiency.getWeaponProfID()))) {
                oldWeaponProf = weaponProficiencyList.stream()
                        .filter(wppr -> wppr.getWeaponProfID().equals(weaponProficiency.getWeaponProfID()))
                        .findFirst().get();

                if (oldWeaponProf.getAuthor().equals(userName))
                    weaponProficiencyList.remove(oldWeaponProf);
            }
        }

        weaponProficiencyList.add(weaponProficiency);
        saveWeaponProficiencies(weaponProficiencyList);
    }

    private static String getNewWpnProfID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String weaponProfID = "";

        List<WeaponProficiency> weaponProficiencyList = getAllWeaponProficiencyObjects();
        Set<String> ids = weaponProficiencyList.stream()
                .map(WeaponProficiency::getWeaponProfID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            weaponProfID = "WPR-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(weaponProfID));


        return weaponProfID;

    }

    public static void deleteWeaponProfByID(String weaponProfID, String userName) {
        List<WeaponProficiency> weaponProficiencyList = getAllWeaponProficiencyObjects();
        WeaponProficiency weaponProficiency = null;

        if (weaponProficiencyList.stream().anyMatch(wp -> wp.getWeaponProfID().equals(weaponProfID))) {
            weaponProficiency = weaponProficiencyList.stream().filter(wppr -> wppr.getWeaponProfID().equals(weaponProfID))
                    .findFirst().get();

            if (weaponProficiency.getAuthor().equals(userName)) {
                weaponProficiencyList.remove(weaponProficiency);
                saveWeaponProficiencies(weaponProficiencyList);
            }
        }

        return;
    }

}

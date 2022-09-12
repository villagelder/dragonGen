package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.Weapon;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class WeaponManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<Weapon> getAllWeaponObjects() {
        List<Weapon> weapons = null;
        try {
            String jsonArray = readFromFile("weapons");
            ObjectMapper objectMapper = new ObjectMapper();
            weapons = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weapons;
    }

    public static List<Weapon> getWeaponsByCategoryAndType(String category, String type) {
        List<Weapon> weapons = null;
        List<Weapon> weaponList = getAllWeaponObjects();

        if (category != null && type != null) {
            weapons = weaponList.stream()
                    .filter(weapon -> weapon.getCategory().equalsIgnoreCase(category))
                    .filter(weapon -> weapon.getType().equalsIgnoreCase(type))
                    .collect(Collectors.toList());
        } else if (type == null) {
            weapons = weaponList.stream()
                    .filter(weapon -> weapon.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        } else {
            weapons = weaponList.stream()
                    .filter(weapon -> weapon.getType().equalsIgnoreCase(type))
                    .collect(Collectors.toList());
        }

        return weapons;
    }

    public static List<Weapon> getWeaponsByAttributes(List<Weapon> weaponList, List<String> attributes) {

        for (String attr : attributes) {
            switch (attr) {
                case "light":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isLight())
                            .collect(Collectors.toList());
                    break;
                case "heavy":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isHeavy())
                            .collect(Collectors.toList());
                    break;
                case "finesse":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isFinesse())
                            .collect(Collectors.toList());
                    break;
                case "twohanded":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isTwohanded())
                            .collect(Collectors.toList());
                    break;
                case "versatile":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isVersatile())
                            .collect(Collectors.toList());
                    break;
                case "thrown":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isThrown())
                            .collect(Collectors.toList());
                    break;
                case "ammunition":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isAmmunition())
                            .collect(Collectors.toList());
                    break;
                case "reach":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isReach())
                            .collect(Collectors.toList());
                    break;
                case "special":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isSpecial())
                            .collect(Collectors.toList());
                    break;
                case "loading":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isLoading())
                            .collect(Collectors.toList());
                    break;
                case "sword":
                    weaponList = weaponList.stream()
                            .filter(weapon -> weapon.isSword())
                            .collect(Collectors.toList());
                    break;

                default:
                    break;

            }


        }

        return weaponList;

    }

    public static void saveWeapons(List<Weapon> weaponList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weaponList);
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

    private static String getNewWeaponID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            String pch = Randomizer.getRandomElement(possibles);
            chList.add(Randomizer.getRandomCharacterFromString(pch));
        }

        return "WPN-" + chList.stream()
                .map(String::valueOf).collect(Collectors.joining());

    }

    public static void saveWeapon(Weapon weapon, String userName) {

        boolean isNewWeapon = false;

        if (weapon.getWeaponID() == null) {
            weapon.setWeaponID(getNewWeaponID());
            isNewWeapon = true;
        }

        List<Weapon> weaponList = getAllWeaponObjects();

        if (weaponList == null)
            weaponList = new ArrayList<>();

        //overwrite
        Weapon oldWeapon = null;
        if (!isNewWeapon) {
            if (weaponList.stream().anyMatch(we -> we.getWeaponID().equals(weapon.getWeaponID()))) {
                oldWeapon = weaponList.stream()
                        .filter(wpn -> wpn.getWeaponID().equals(weapon.getWeaponID()))
                        .findFirst().get();

                if (oldWeapon.getAuthor().equals(userName))
                    weaponList.remove(oldWeapon);
            }
        }

        weaponList.add(weapon);
        saveWeapons(weaponList);
    }

    public static Weapon getWeaponByName(List<Weapon> weaponList, String wpnName) {
        return weaponList.stream()
                .filter(wpn -> wpn.getWeaponName().equalsIgnoreCase(wpnName))
                .findFirst()
                .get();

    }


    public static void deleteWeaponByID(String weaponID, String userName) {
        List<Weapon> weaponList = getAllWeaponObjects();
        Weapon weapon = null;

        if (weaponList.stream().anyMatch(wp -> wp.getWeaponID().equals(weaponID))) {
            weapon = weaponList.stream().filter(wpn -> wpn.getWeaponID().equals(weaponID))
                    .findFirst().get();

            if (weapon.getAuthor().equals(userName)) {
                weaponList.remove(weapon);
                saveWeapons(weaponList);
            }
        }

        return;
    }

}

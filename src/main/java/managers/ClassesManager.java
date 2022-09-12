package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class ClassesManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<CharacterClass> getAllClassObjects() {
        List<CharacterClass> characterClasses = null;
        try {
            String jsonArray = readFromFile("classes");
            ObjectMapper objectMapper = new ObjectMapper();
            characterClasses = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterClasses;
    }

    public static List<String> getAllClassNames() {
        List<CharacterClass> characterClasses = getAllClassObjects();
        List<String> classNames = new ArrayList<>();

        for (CharacterClass cc : characterClasses) classNames.add(cc.getClassName());
        return classNames;
    }

    public static Set<CharacterClass> getCharacterClassesBySources(Set<String> sources) {
        List<CharacterClass> classList = getAllClassObjects();
        Set<CharacterClass> classes = new HashSet<>();

        for (String source : sources) {
            classes.addAll(classList.stream()
                    .filter(cl -> cl.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return classes;
    }

    public static void saveCharacterClasses(List<CharacterClass> characterClassList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(characterClassList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "classes.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveCharacterClass(CharacterClass chClass, String userName) {

        boolean isNewClass = false;

        if (chClass.getClassID() == null) {
            chClass.setClassID(getNewClassID());
            isNewClass = true;
        }

        List<CharacterClass> characterClassList = getAllClassObjects();

        if (characterClassList == null)
            characterClassList = new ArrayList<>();

        //overwrite
        CharacterClass oldClass = null;
        if (!isNewClass) {
            if (characterClassList.stream().anyMatch(cl -> cl.getClassID().equals(chClass.getClassID()))) {
                oldClass = characterClassList.stream()
                        .filter(chcl -> chcl.getClassID().equals(chClass.getClassID()))
                        .findFirst().get();

                if (oldClass.getAuthor().equals(userName))
                    characterClassList.remove(oldClass);
            }
        }

        characterClassList.add(chClass);
        saveCharacterClasses(characterClassList);
    }

    private static String getNewClassID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String classID = "";

        List<CharacterClass> characterClassList = getAllClassObjects();
        Set<String> ids = characterClassList.stream()
                .map(CharacterClass::getClassID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            classID = "CL-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(classID));

        return classID;

    }

    public static CharacterClass getRandomClass(String chClass) {
        CharacterClass randomClass = null;
        List<CharacterClass> characterClasses = ClassesManager.getAllClassObjects();
        Random rand = new Random();

        if (chClass != null) {
            randomClass = characterClasses.stream()
                    .filter(cc -> cc.getClassName().equalsIgnoreCase(chClass))
                    .findFirst().get();

            if (randomClass != null)
                return randomClass;
        }

        return characterClasses.get(rand.nextInt(characterClasses.size()));
    }

    public static CharacterClass getCharacterClassByName(String className) {

        List<CharacterClass> classList = getAllClassObjects();

        return classList.stream()
                .filter(cl -> cl.getClassName().equalsIgnoreCase(className))
                .findFirst()
                .get();

    }

    public static Map<String, Integer> generateStartingEquipment(CharacterClass characterClass) {
        List<String> equipmentList = new ArrayList<>();
        Map<String, Integer> inventory = new HashMap<>();
        Map<String, List<String>> equipmentChoices = characterClass.getEquipmentChoices();

        for (Map.Entry<String, List<String>> entry : equipmentChoices.entrySet()) {
            if (!entry.getValue().isEmpty())
                equipmentList.add(Randomizer.getRandomElement(entry.getValue()));
        }

        String clName = characterClass.getClassName().toLowerCase();

        switch (clName) {
            case "paladin":
            case "fighter":
                boolean hasShield = equipmentList.stream()
                        .anyMatch(eq -> eq.endsWith(", Shield"));

                if (!hasShield) {
                    List<Weapon> weapons = WeaponManager.getWeaponsByCategoryAndType("martial", "melee");

                    Weapon wpn = (Weapon) Randomizer.getRandomObject(weapons);
                    equipmentList.add(wpn.getWeaponName());
                }
                break;
            case "ranger":
                boolean hasSwords = equipmentList.stream()
                        .anyMatch(eq -> eq.equalsIgnoreCase("shortswords (2)"));

                if (!hasSwords) {
                    List<Weapon> weapons = WeaponManager.getWeaponsByCategoryAndType("simple", "melee");

                    for (int i = 2; i > 0; i--) {
                        Weapon wpn = (Weapon) Randomizer.getRandomObject(weapons);
                        equipmentList.add(wpn.getWeaponName());
                    }
                    break;

                }
            default:
                break;
        }
        equipmentList.addAll(characterClass.getEquipmentFree());

        for (String eq : equipmentList) {
            String equip = null;
            int qty = 1;

            if (eq.equals("Light Crossbow, Bolts (20)")) {
                equip = "Light Crossbow";
                inventory.put("Bolt", 20);
                inventory.put("Quiver", 1);
            } else if (eq.equals("Leather Armor, Longbow, Arrows (20)")) {
                equip = "Longbow";
                inventory.put("Arrows", 20);
                inventory.put("Leather Armor", 1);
                inventory.put("Quiver", 1);
            } else if (eq.equals("Shortbow, Quiver, Arrows (20)")) {
                equip = "Shortbow";
                inventory.put("Arrow", 20);
                inventory.put("Leather Armor", 1);
                inventory.put("Quiver", 1);
            } else if (eq.contains("(")) {
                qty = Integer.parseInt(eq.substring(eq.indexOf("(") + 1, eq.indexOf(")")));
                equip = eq.substring(0, eq.indexOf("(") - 1);
            } else {
                if (eq.contains(", Shield")) {
                    equip = eq.substring(0, eq.indexOf(","));
                    inventory.put("Shield", 1);
                } else {
                    equip = eq;
                }
            }

            if (inventory.containsKey(equip)) {
                inventory.put(equip, inventory.get(equip) + qty);

            } else {
                inventory.put(equip, qty);
            }


        }

        return inventory;
    }

    public static void deleteClassByID(String classID, String userName) {
        List<CharacterClass> characterClassList = getAllClassObjects();
        CharacterClass chClass = null;

        if (characterClassList.stream().anyMatch(cl -> cl.getClassID().equals(classID))) {
            chClass = characterClassList.stream().filter(chcl -> chcl.getClassID().equals(classID))
                    .findFirst().get();

            if (chClass.getAuthor().equals(userName)) {
                characterClassList.remove(chClass);
                saveCharacterClasses(characterClassList);
            }
        }

        return;
    }
}




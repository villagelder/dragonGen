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

public class ArmorProficienciesManager {


    private static String basePath = "src/main/java/data/jsondata/";

    public static List<ArmorProficiency> getAllArmorProficiencyObjects() {
        List<ArmorProficiency> armorProficiencies = null;
        try {
            String jsonArray = readFromFile("armorproficiencies");
            ObjectMapper objectMapper = new ObjectMapper();
            armorProficiencies = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return armorProficiencies;
    }

    public static ArmorProficiency getArmorProficiencyByName(List<ArmorProficiency> apList, String apName) {
        return apList.stream()
                .filter(ap -> ap.getArmorProf().equalsIgnoreCase(apName))
                .findFirst()
                .get();

    }

    private static void saveArmorProficiencies(List<ArmorProficiency> armorProficiencyList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(armorProficiencyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "armorproficiencies.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveArmorProficiency(ArmorProficiency armorProf, String username) {

        boolean isNewArmorProf = false;

        if (armorProf.getArmorProficiencyID() == null) {
            armorProf.setArmorProficiencyID(getNewArmorProfID());
            isNewArmorProf = true;
        }

        List<ArmorProficiency> armorProficiencyList = getAllArmorProficiencyObjects();

        if (armorProficiencyList == null)
            armorProficiencyList = new ArrayList<>();

        //overwrite
        ArmorProficiency oldArmorProf = null;
        if (!isNewArmorProf) {
            if (armorProficiencyList.stream().anyMatch(ap -> ap.getArmorProficiencyID().equals(armorProf.getArmorProficiencyID()))) {
                oldArmorProf = armorProficiencyList.stream()
                        .filter(arp -> arp.getArmorProficiencyID().equals(armorProf.getArmorProficiencyID()))
                        .findFirst().get();
                if (oldArmorProf.getAuthor().equals(username))
                    armorProficiencyList.remove(oldArmorProf);
            }
        }

        armorProficiencyList.add(armorProf);
        saveArmorProficiencies(armorProficiencyList);
    }

    public static void assignArmorProfsID() {
        List<ArmorProficiency> armorProficiencyList = getAllArmorProficiencyObjects();

        armorProficiencyList.forEach(ap -> ap.setArmorProficiencyID(getNewArmorProfID()));

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(armorProficiencyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "armorproficiencies.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Set<ArmorProficiency> getArmorProfsBySources(Set<String> sourceList) {
        List<ArmorProficiency> armorProficiencyList = getAllArmorProficiencyObjects();
        Set<ArmorProficiency> armorProficiencies = new HashSet<>();

        for (String source : sourceList) {
            armorProficiencies.addAll(armorProficiencyList.stream()
                    .filter(ap -> ap.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }
        return armorProficiencies;
    }

    private static String getNewArmorProfID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String armorProfID = "";

        List<ArmorProficiency> armorProficiencyList = getAllArmorProficiencyObjects();
        Set<String> ids = armorProficiencyList.stream()
                .map(ArmorProficiency::getArmorProficiencyID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            armorProfID = "AP-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(armorProfID));

        return armorProfID;


    }

}

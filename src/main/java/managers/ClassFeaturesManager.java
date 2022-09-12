package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.ClassFeature;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class ClassFeaturesManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<ClassFeature> getAllClassFeatureObjects() {
        List<ClassFeature> classFeatures = null;
        try {
            String jsonArray = readFromFile("classFeatures");
            ObjectMapper objectMapper = new ObjectMapper();
            classFeatures = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classFeatures;
    }

    public static List<ClassFeature> getFeaturesByClassAndArchetype(String className, String archetype, int level) {
        //includes base class features
        List<ClassFeature> allFeatures = getAllClassFeatureObjects();
        List<ClassFeature> classFeatures = new ArrayList<>();

        classFeatures = allFeatures.stream()
                .filter(cf -> cf.getClassName().equalsIgnoreCase(className) && (cf.getArchetype().equalsIgnoreCase(archetype) || cf.getArchetype().equalsIgnoreCase("base")))
                .filter(cfl -> cfl.getLevel() <= level)
                .sorted(Comparator.comparingInt(ClassFeature::getLevel))
                .collect(Collectors.toList());

        return classFeatures;

    }

    public static Set<ClassFeature> getClassFeaturesBySources(Set<String> sources) {
        List<ClassFeature> classFeatureList = getAllClassFeatureObjects();
        Set<ClassFeature> classFeatures = new HashSet<>();

        for (String source : sources) {
            classFeatures.addAll(classFeatureList.stream()
                    .filter(ar -> ar.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return classFeatures;
    }

    public static void saveClassFeatures(List<ClassFeature> classFeatureList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(classFeatureList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "classFeatures.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveClassFeature(ClassFeature classFeature, String userName) {

        boolean isNewClassFeature = false;

        if (classFeature.getFeatureID() == null) {
            classFeature.setFeatureID(getNewFeatureID());
            isNewClassFeature = true;
        }

        List<ClassFeature> classFeatureList = getAllClassFeatureObjects();

        if (classFeatureList == null)
            classFeatureList = new ArrayList<>();

        //overwrite
        ClassFeature oldFeature = null;
        if (!isNewClassFeature) {
            if (classFeatureList.stream().anyMatch(cf -> cf.getFeatureID().equals(classFeature.getFeatureID()))) {
                oldFeature = classFeatureList.stream()
                        .filter(clf -> clf.getFeatureID().equals(classFeature.getFeatureID()))
                        .findFirst().get();

                if (oldFeature.getAuthor().equals(userName))
                    classFeatureList.remove(oldFeature);
            }
        }

        classFeatureList.add(classFeature);
        saveClassFeatures(classFeatureList);
    }

    private static String getNewFeatureID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String classFeatureID = "";

        List<ClassFeature> classFeatureList = getAllClassFeatureObjects();
        Set<String> ids = classFeatureList.stream()
                .map(ClassFeature::getFeatureID)
                .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            classFeatureID = "CLF-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(classFeatureID));

        return classFeatureID;

    }

    public static void deleteClassFeatureByID(String featureID, String userName) {
        List<ClassFeature> classFeatureList = getAllClassFeatureObjects();
        ClassFeature classFeature = null;

        if (classFeatureList.stream().anyMatch(cf -> cf.getFeatureID().equals(featureID))) {
            classFeature = classFeatureList.stream().filter(clf -> clf.getFeatureID().equals(featureID))
                    .findFirst().get();

            if (classFeature.getAuthor().equals(userName)) {
                classFeatureList.remove(classFeature);
                saveClassFeatures(classFeatureList);
            }
        }

        return;
    }
}

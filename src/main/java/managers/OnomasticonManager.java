package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Onomasticon;
import utilities.Randomizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class OnomasticonManager {

    public static List<Onomasticon> getAllOnomasticonsInFile(String fileName) {

        List<Onomasticon> onomasticons = new ArrayList<>();
        try {
            String jsonArray = readFromFile("onomasticon/ono-" + fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            onomasticons = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return onomasticons;
    }

    public static Set<String> getAllSubjectsInFile(String fileName) {

        return getAllOnomasticonsInFile(fileName).stream()
                .map(sub -> sub.getSubject())
                .collect(Collectors.toSet());
    }

    public static Onomasticon getOnomasticonBySubjectName(String fileName, String subject) {
        List<Onomasticon> onomasticonList = getAllOnomasticonsInFile(fileName);
        Onomasticon onomasticon = null;

        if (onomasticonList.stream().anyMatch(ono -> ono.getSubject().equalsIgnoreCase(subject)))
            onomasticon = onomasticonList.stream()
                    .filter(onom -> onom.getSubject().equalsIgnoreCase(subject))
                    .findFirst().get();

        return onomasticon;

    }

    public static String getRandomMetonymBySubject(String fileName, String subject) {
        Onomasticon ono = getOnomasticonBySubjectName(fileName, subject);
        return Randomizer.getRandomElement(ono.getMetonym());

    }

    public static String getRandomActionBySubject(String fileName, String subject) {
        Onomasticon ono = getOnomasticonBySubjectName(fileName, subject);
        return Randomizer.getRandomElement(ono.getAction());

    }

    public static String getRandomDescriptorBySubject(String fileName, String subject) {
        Onomasticon ono = getOnomasticonBySubjectName(fileName, subject);
        return Randomizer.getRandomElement(ono.getDescriptor());

    }

    public static String getRandomSubstantiveBySubject(String fileName, String subject) {
        Onomasticon ono = getOnomasticonBySubjectName(fileName, subject);
        return Randomizer.getRandomElement(ono.getSubstantive());
    }
}

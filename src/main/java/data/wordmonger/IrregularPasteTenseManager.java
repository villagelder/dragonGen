package data.wordmonger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.IrregularPastTense;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class IrregularPasteTenseManager {

    public static List<IrregularPastTense> getAllIrregularPastTenseObjects() {
        List<IrregularPastTense> pastTenseList = null;
        try {
            String jsonArray = readFromFile("irregularPastTense");
            ObjectMapper objectMapper = new ObjectMapper();
            pastTenseList = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pastTenseList;
    }

    public static Set<String> getAllWordsOfIrrPastTense() {
        List<IrregularPastTense> pastTenseList = getAllIrregularPastTenseObjects();
        Set<String> words = pastTenseList.stream()
                .map(w -> w.getWord())
                .collect(Collectors.toSet());

        return words;
    }

    public static String getIrrPastTenseOfWord(String word) {
        List<IrregularPastTense> pastTenseList = getAllIrregularPastTenseObjects();
        IrregularPastTense ipt = null;
        if (pastTenseList.stream()
                .anyMatch(w -> w.getWord().equalsIgnoreCase(word)))
            ipt = pastTenseList.stream()
                    .filter(wd -> wd.getWord().equalsIgnoreCase(word))
                    .findFirst()
                    .get();

        if (ipt == null)
            return null;
        return ipt.getPastTense();

    }

}

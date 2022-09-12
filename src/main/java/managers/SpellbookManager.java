package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Feat;
import models.SpellBook;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class SpellbookManager {

    private static String basePath = "src/main/java/data/jsondata/";

    public static List<SpellBook> getAllSpellBookObjects() {
        List<SpellBook> spellBookList = null;
        try {
            String jsonArray = readFromFile("spellbooks");
            if (jsonArray == null)
                return null;
            ObjectMapper objectMapper = new ObjectMapper();
            spellBookList = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spellBookList;
    }

    public static SpellBook getSpellBookByName(String bookName) {
        List<SpellBook> spellBookList = getAllSpellBookObjects();
        SpellBook spellBook = null;

        if (spellBookList.stream().anyMatch(ft -> ft.getBookName().equalsIgnoreCase(bookName)))
            spellBook = spellBookList.stream()
                    .filter(f -> f.getBookName().equalsIgnoreCase(bookName))
                    .findFirst().get();


        return spellBook;

    }

    public static Set<String> getAllSpellBookNames() {
        List<SpellBook> spellBookList = getAllSpellBookObjects();
        return spellBookList.stream()
                .map(f -> f.getBookName())
                .collect(Collectors.toSet());

    }

    public static Set<SpellBook> getSpellBooksBySources(Set<String> sources) {
        List<SpellBook> spellBookList = getAllSpellBookObjects();
        Set<SpellBook> spellBooks = new HashSet<>();

        for (String source : sources) {
            spellBooks.addAll(spellBookList.stream()
                    .filter(spellBook -> spellBook.getSource().equalsIgnoreCase(source))
                    .collect(Collectors.toSet()));
        }

        return spellBooks;
    }

    public static void saveSpellBooks(List<SpellBook> spellBookList) {

        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(spellBookList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String p = basePath + "spellbooks.json";

        Path path = Paths.get(p);
        byte[] strToBytes = json.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveSpellBook(SpellBook spellBook, String userName) {

        boolean isNewSpellBook = false;

        if (spellBook.getSpellbookID() == null) {
            spellBook.setSpellbookID(getNewSpellBookID());
            isNewSpellBook = true;
        }

        List<SpellBook> spellBookList = getAllSpellBookObjects();

        if (spellBookList == null)
            spellBookList = new ArrayList<>();

        //overwrite
        SpellBook oldSpellBook = null;
        if (!isNewSpellBook) {
            if (spellBookList.stream().anyMatch(sb -> sb.getSpellbookID().equals(spellBook.getSpellbookID()))) {
                oldSpellBook = spellBookList.stream()
                        .filter(spb -> spb.getSpellbookID().equals(spellBook.getSpellbookID()))
                        .findFirst().get();

                if (oldSpellBook.getAuthor().equals(userName))
                    spellBookList.remove(oldSpellBook);
            }
        }

        spellBookList.add(spellBook);
        saveSpellBooks(spellBookList);
    }

    private static String getNewSpellBookID() {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        String spellBookID = "";

        List<SpellBook> spellBookList = getAllSpellBookObjects();

        Set<String> ids = new HashSet<>();

        if (spellBookList != null)
            ids = spellBookList.stream()
                    .map(SpellBook::getSpellbookID)
                    .collect(Collectors.toSet());

        List<String> possibles = Arrays.asList(upper, digits);
        List<Character> chList = new ArrayList<>();

        do {
            for (int i = 0; i < 12; i++) {
                String pch = Randomizer.getRandomElement(possibles);
                chList.add(Randomizer.getRandomCharacterFromString(pch));
            }

            spellBookID = "SPBK-" + chList.stream().map(String::valueOf).collect(Collectors.joining());

        } while (ids.contains(spellBookID));

        return spellBookID;

    }

    public static void deleteSpellBookByID(String spellBookID, String userName) {
        List<SpellBook> spellBookList = getAllSpellBookObjects();
        SpellBook spellBook = null;

        if (spellBookList.stream().anyMatch(sp -> sp.getSpellbookID().equals(spellBookID))) {
            spellBook = spellBookList.stream().filter(spb -> spb.getSpellbookID().equals(spellBookID))
                    .findFirst().get();

            if (spellBook.getAuthor().equals(userName)) {
                spellBookList.remove(spellBook);
                saveSpellBooks(spellBookList);
            }
        }
        return;
    }

}

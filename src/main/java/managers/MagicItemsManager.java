package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.wordmonger.Transfigure;
import models.CharacterClass;
import models.MagicItem;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static managers.ReadFile.readFromFile;

public class MagicItemsManager {

    public static List<MagicItem> getAllMagicItemsObjects() {
        List<MagicItem> magicItems = null;
        try {
            String jsonArray = readFromFile("magicitems");
            ObjectMapper objectMapper = new ObjectMapper();
            magicItems = objectMapper.readValue(jsonArray, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return magicItems;
    }

    public static List<MagicItem> getMagicItemsByRarity(List<MagicItem> allMagicItems, String rarity) {


        List<MagicItem> filteredMagicItems = allMagicItems.stream()
                .filter(magicItem -> rarity.equalsIgnoreCase(magicItem.getRarity()))
                .sorted(Comparator.comparing(MagicItem::getItem))
                .collect(Collectors.toList());

        return filteredMagicItems;
    }

    public static Set<MagicItem> getMagicItemsByTypeAndRarity(List<MagicItem> allMagicItems, String type, String rarity) {
        Set<MagicItem> filteredMagicItems = null;

        if (rarity == null && type == null) {
            filteredMagicItems = new HashSet<>(allMagicItems);
        } else if (type == null) {
            filteredMagicItems = allMagicItems.stream()
                    .filter(magicItem -> rarity.trim().equalsIgnoreCase(magicItem.getRarity()))
                    .collect(Collectors.toSet());
        } else if (rarity == null) {
            filteredMagicItems = allMagicItems.stream()
                    .filter(magicItem -> type.trim().equalsIgnoreCase(magicItem.getType()))
                    .collect(Collectors.toSet());
        } else {
            filteredMagicItems = allMagicItems.stream()
                    .filter(magicItem -> type.trim().equalsIgnoreCase(magicItem.getType()))
                    .filter(magicItem -> rarity.trim().equalsIgnoreCase((magicItem.getRarity())))
                    .collect(Collectors.toSet());
        }

        return filteredMagicItems;
    }

    public static List<MagicItem> getMagicItemByName(List<MagicItem> allMagicItems, String name) {

        List<MagicItem> filteredMagicItems = allMagicItems.stream()
                .filter(magicItem -> name.equalsIgnoreCase(magicItem.getItem()))
                .sorted(Comparator.comparing(MagicItem::getItem))
                .collect(Collectors.toList());

        return filteredMagicItems;
    }

    public static Set<MagicItem> getMagicItemsByLikeName(List<MagicItem> allMagicItems, String title) {
        title = title.toLowerCase();

        List<String> wordList = Transfigure.parseAndAbridge(title);
        Set<MagicItem> filteredMagicItems = new HashSet<>();

        if (wordList.size() < 2) {
            String word = wordList.get(0);

            Set<MagicItem> tempSet = allMagicItems.stream()
                    .filter(magicItem -> magicItem.getItem().toLowerCase().contains(word))
                    .collect(Collectors.toSet());

            filteredMagicItems.addAll(tempSet);

        } else {


            for (int i = 0; i < wordList.size() - 1; i++) {
                String word = wordList.get(i);
                String word2 = wordList.get(i + 1);

                Set<MagicItem> tempSet = allMagicItems.stream()
                        .filter(magicItem -> magicItem.getItem().toLowerCase().contains(word) && magicItem.getItem().toLowerCase().contains(word2))
                        .collect(Collectors.toSet());

                filteredMagicItems.addAll(tempSet);
            }

            for (int i = 0; i < wordList.size() - 2; i++) {
                String w = wordList.get(i);
                String uu = wordList.get(i + 2);

                Set<MagicItem> tempSet = allMagicItems.stream()
                        .filter(magicItem -> magicItem.getItem().toLowerCase().contains(w) && magicItem.getItem().toLowerCase().contains(uu))
                        .collect(Collectors.toSet());

                filteredMagicItems.addAll(tempSet);
            }
        }

        List<MagicItem> items = getMagicItemsByRarity(allMagicItems, title);

        if (!items.isEmpty())
            filteredMagicItems.addAll(items);

        return filteredMagicItems;
    }
}

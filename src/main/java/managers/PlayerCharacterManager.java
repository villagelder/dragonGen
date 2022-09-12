package managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Armor;
import models.CharacterClass;
import models.PlayerCharacter;
import utilities.Randomizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static managers.ReadFile.readFromFile;

public class PlayerCharacterManager {

    private static final String basePath = "src/main/java/data/jsondata/players/";

    public static List<PlayerCharacter> getAllPlayersCharacters(String userID) {
        List<PlayerCharacter> playerCharacters = null;
        try {
            String filekey = "players/PC-" + userID.substring(0, 12);
            String jsonString = readFromFile(filekey);

            if (jsonString == null)
                return null;

            final ObjectMapper mapper = new ObjectMapper();
            playerCharacters = mapper.readValue(jsonString, new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerCharacters;
    }

    public static void savePlayerCharacter(PlayerCharacter pc, String userID) {
        try {
            String filekey = "PC-" + userID.substring(0, 12);
            List<PlayerCharacter> pcList = getAllPlayersCharacters(userID);

            if (pcList == null)
                pcList = new ArrayList<>();

            //overwrite
            PlayerCharacter nowPC = null;
            if (pcList.stream().anyMatch(pct -> pct.getPcid().equals(pc.getPcid()))) {
                nowPC = pcList.stream()
                        .filter(opc -> opc.getPcid().equals(pc.getPcid()))
                        .findFirst().get();

                pcList.remove(nowPC);
            }

            pcList.add(pc);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pcList);
            String p = basePath + filekey + ".json";

            Path path = Paths.get(p);
            byte[] strToBytes = json.getBytes();

            Files.write(path, strToBytes);

        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static PlayerCharacter getPCbyID(String userID, String pcid) {
        List<PlayerCharacter> pcList = getAllPlayersCharacters(userID);
        PlayerCharacter playerCharacter = null;

        if (pcList.stream().anyMatch(pch -> pch.getPcid().equals(pcid))) {
            playerCharacter = pcList.stream()
                    .filter(pc -> pc.getPcid().equals(pcid))
                    .findFirst().get();
        }

        return playerCharacter;
    }

    public static void deletePlayerCharacterByID(String userID, String pcID) {
        List<PlayerCharacter> pcList = getAllPlayersCharacters(userID);
        PlayerCharacter pc = null;

        if (pcList.stream().anyMatch(sp -> sp.getPcid().equals(pcID))) {
            pc = pcList.stream().filter(spl -> spl.getPcid().equals(pcID))
                    .findFirst().get();
            pcList.remove(pc);
        }

        return;
    }

    public static PlayerCharacter createNewPC(String userId) {

        PlayerCharacter pc = new PlayerCharacter();
        pc.setPcid(Randomizer.getNewPCIDToken());
        pc.setUserId(userId);

        return pc;
    }

    public static int calculateTotalLevel(PlayerCharacter pc) {
        int lvl = 0;
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        for (String key : levelMap.keySet()) {
            String clName = key;
            for (String k : levelMap.get(key).keySet()) {
                lvl = lvl + levelMap.get(key).get(k);

            }
        }
        return lvl;
    }

    public static int calculateProficiencyBonus(int totalLevel) {

        int profBonus = ((totalLevel + 3) / 4) + 1;
        return (int) profBonus;

    }

    public static int calculateArmorClass(Armor armor, Armor shield, int dexBonus) {

        int a = 0;
        int s = 0;
        int maxDexBonus = dexBonus;

        if (armor != null) {
            a = armor.getArmorClass();
            if (!armor.getProficiency().equalsIgnoreCase("light"))
                maxDexBonus = armor.getDexMax();
        }

        if (shield != null) {
            s = shield.getArmorClass();
            maxDexBonus = shield.getDexMax() < maxDexBonus ? shield.getDexMax() : maxDexBonus;
        }

        if (armor == null && shield == null)
            return 10 + dexBonus;

        return a + s + maxDexBonus;
    }

    public static int calculateUnarmoredAC(String clName, int dexBonus, int conBonus, int wisBonus) {
        int ac = 10;

        if (clName.equalsIgnoreCase("barbarian")) {
            ac = ac + dexBonus + conBonus;
        } else if (clName.equalsIgnoreCase("monk")) {
            ac = ac + dexBonus + wisBonus;
        } else {
            ac = ac + dexBonus;
        }

        return ac;
    }

    public static int calculateAbilityModifier(int abilityScore) {
        return (abilityScore / 2) - 5;

    }

    public static Set<String> getAllWeaponsFromProficiencies(PlayerCharacter pc) {
        Set<String> wpnProfs = WeaponProficiencyManager.getWeaponProficiencies();
        Set<String> weapons = new HashSet<>();
        Set<String> playerWpnProfs = pc.getWeaponProfs();

        for (String prof : playerWpnProfs) {
            if (wpnProfs.contains(prof)) {
                weapons.addAll(WeaponProficiencyManager.getWeaponsInProficiency(prof));
            } else {
                weapons.add(prof);
            }
        }
        return weapons;
    }

    public static boolean isProficientWithWeapon(PlayerCharacter pc, String weapon) {
        if (getAllWeaponsFromProficiencies(pc).contains(weapon))
            return true;

        return false;
    }

    public static Map<String, Integer> calculateSkillCheckModifiers(PlayerCharacter pc) {
        Map<String, Integer> skillBonuses = new HashMap<>();
        Set<String> skillProfs = pc.getSkillProfs();

        int profBonus = pc.getProficiencyBonus();


        skillBonuses.put("Athletics", calculateSkillModifier(pc, "Athletics"));
        skillBonuses.put("Acrobatics", calculateSkillModifier(pc, "Acrobatics"));
        skillBonuses.put("Sleight of Hand", calculateSkillModifier(pc, "Sleight of Hand"));
        skillBonuses.put("Stealth", calculateSkillModifier(pc, "Stealth"));
        skillBonuses.put("Arcana", calculateSkillModifier(pc, "Arcana"));
        skillBonuses.put("History", calculateSkillModifier(pc, "History"));
        skillBonuses.put("Investigation", calculateSkillModifier(pc, "Investigation"));
        skillBonuses.put("Nature", calculateSkillModifier(pc, "Nature"));
        skillBonuses.put("Religion", calculateSkillModifier(pc, "Religion"));
        skillBonuses.put("Animal Handling", calculateSkillModifier(pc, "Animal Handling"));
        skillBonuses.put("Insight", calculateSkillModifier(pc, "Insight"));
        skillBonuses.put("Medicine", calculateSkillModifier(pc, "Medicine"));
        skillBonuses.put("Perception", calculateSkillModifier(pc, "Perception"));
        skillBonuses.put("Survival", calculateSkillModifier(pc, "Survival"));
        skillBonuses.put("Deception", calculateSkillModifier(pc, "Deception"));
        skillBonuses.put("Intimidation", calculateSkillModifier(pc, "Intimidation"));
        skillBonuses.put("Performance", calculateSkillModifier(pc, "Performance"));
        skillBonuses.put("Persuasion", calculateSkillModifier(pc, "Persuasion"));

        return skillBonuses;
    }

    public static int calculateSkillModifier(PlayerCharacter pc, String skill) {
        int mod = 0;
        Set<String> expertSkills = pc.getExpertSkills();

        switch (skill) {
            case "Athletics":
                mod = expertSkills.contains(skill) ? pc.getProficiencyBonus() * 2 + pc.getAbilityModifiersMap().get("str") : pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("str");
                break;
            case "Acrobatics":
            case "Sleight of Hand":
            case "Stealth":
                mod = expertSkills.contains(skill) ? pc.getProficiencyBonus() * 2 + pc.getAbilityModifiersMap().get("dex") : pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("dex");
                break;
            case "Arcana":
            case "History":
            case "Investigation":
            case "Nature":
            case "Religion":
                mod = expertSkills.contains(skill) ? pc.getProficiencyBonus() * 2 + pc.getAbilityModifiersMap().get("int") : pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("int");
                break;
            case "Animal Handling":
            case "Insight":
            case "Medicine":
            case "Perception":
            case "Survival":
                mod = expertSkills.contains(skill) ? pc.getProficiencyBonus() * 2 + pc.getAbilityModifiersMap().get("wis") : pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("wis");
                break;
            case "Deception":
            case "Intimidation":
            case "Performance":
            case "Persuasion":
                mod = expertSkills.contains(skill) ? pc.getProficiencyBonus() * 2 + pc.getAbilityModifiersMap().get("cha") : pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("cha");
                break;

            default:
                break;

        }

        return mod;
    }

    public static Map<String, Integer> calculateAbilityModifiers(PlayerCharacter pc) {
        Map<String, Integer> abilityMods = new HashMap<>() {
            {
                put("str", calculateAbilityModifier(pc.getStrength()));
                put("dex", calculateAbilityModifier(pc.getDexterity()));
                put("con", calculateAbilityModifier(pc.getConstitution()));
                put("int", calculateAbilityModifier(pc.getIntelligence()));
                put("wis", calculateAbilityModifier(pc.getWisdom()));
                put("cha", calculateAbilityModifier(pc.getCharisma()));
            }
        };

        return abilityMods;
    }

    public static Map<String, Integer> calculatePassiveSkills(PlayerCharacter pc) {
        Map<String, Integer> passiveSkills = new HashMap<>();

        passiveSkills.put("Passive Athletics", pc.getAbilityModifiersMap().get("str") + 10);
        passiveSkills.put("Passive Acrobatics", pc.getAbilityModifiersMap().get("dex") + 10);
        passiveSkills.put("Passive Sleight of Hand", pc.getAbilityModifiersMap().get("dex") + 10);
        passiveSkills.put("Passive Stealth", pc.getAbilityModifiersMap().get("dex") + 10);
        passiveSkills.put("Passive Arcana", pc.getAbilityModifiersMap().get("int") + 10);
        passiveSkills.put("Passive History", pc.getAbilityModifiersMap().get("int") + 10);
        passiveSkills.put("Passive Investigation", pc.getAbilityModifiersMap().get("int") + 10);
        passiveSkills.put("Passive Nature", pc.getAbilityModifiersMap().get("int") + 10);
        passiveSkills.put("Passive Religion", pc.getAbilityModifiersMap().get("int") + 10);
        passiveSkills.put("Passive Animal Handling", pc.getAbilityModifiersMap().get("wis") + 10);
        passiveSkills.put("Passive Insight", pc.getAbilityModifiersMap().get("wis") + 10);
        passiveSkills.put("Passive Medicine", pc.getAbilityModifiersMap().get("wis") + 10);
        passiveSkills.put("Passive Perception", pc.getAbilityModifiersMap().get("wis") + 10);
        passiveSkills.put("Passive Survival", pc.getAbilityModifiersMap().get("wis") + 10);
        passiveSkills.put("Passive Deception", pc.getAbilityModifiersMap().get("cha") + 10);
        passiveSkills.put("Passive Intimidation", pc.getAbilityModifiersMap().get("cha") + 10);
        passiveSkills.put("Passive Performance", pc.getAbilityModifiersMap().get("cha") + 10);
        passiveSkills.put("Passive Persuasion", pc.getAbilityModifiersMap().get("cha") + 10);

        return passiveSkills;
    }

    public static int calculateNumberOfAttacks(PlayerCharacter pc) {
        int numAttacks = 0;
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        for (String key : levelMap.keySet()) {
            String clName = key;
            for (String k : levelMap.get(key).keySet()) {
                int lvl = levelMap.get(key).get(k);

                switch (clName.toLowerCase()) {
                    //barbarian, monk, paladin, ranger lvl 5   +1
                    // fighter lvl 5, 11, 20  +1

                    case "barbarian":
                    case "monk":
                    case "paladin":
                    case "ranger":
                        if (lvl > 4) {
                            numAttacks = 2;
                        } else {
                            numAttacks = 1;
                        }
                        break;
                    case "fighter":
                        if (lvl == 20) {
                            numAttacks = 4;
                        } else if (lvl > 10) {
                            numAttacks = 3;
                        } else if (lvl > 4) {
                            numAttacks = 2;
                        } else {
                            numAttacks = 1;
                        }
                        break;
                    default:
                        numAttacks = 1;
                        break;
                }


            }
        }
        return numAttacks;
    }

    public static int calculateUnarmedAttack(PlayerCharacter pc) {
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        boolean isMonk = false;
        int ua = 0;
        int strBonus = pc.getAbilityModifiersMap().get("str");
        int dexBonus = pc.getAbilityModifiersMap().get("dex");

        if (levelMap.keySet().contains("Monk"))
            isMonk = true;

        if (isMonk) {
            ua = strBonus > dexBonus ? pc.getProficiencyBonus() + strBonus : pc.getProficiencyBonus() + dexBonus;
        } else {
            ua = pc.getProficiencyBonus() + strBonus;
        }
        return ua;
    }

    public static int calculateSpellSaveDC(PlayerCharacter pc) {
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        int lvl = 0;
        String clName = null;
        String archetype = null;
        int saveDC = 0;

        for (String key : levelMap.keySet()) {
            clName = key;
            for (String k : levelMap.get(key).keySet()) {
                archetype = k;
                lvl = levelMap.get(key).get(k);
            }
        }

        int abilityBonus = 0;
        switch (clName.toLowerCase()) {

            case "wizard":
                abilityBonus = pc.getAbilityModifiersMap().get("int");
                saveDC = 8 + pc.getProficiencyBonus() + abilityBonus;
            case "fighter":
            case "rogue":
                if (archetype.toLowerCase().equalsIgnoreCase("eldritch knight") || archetype.toLowerCase().equalsIgnoreCase("arcane trickster")) {
                    abilityBonus = pc.getAbilityModifiersMap().get("int");
                    saveDC = 8 + pc.getProficiencyBonus() + abilityBonus;
                }
                break;
            case "bard":
            case "paladin":
            case "sorcerer":
            case "warlock":
                abilityBonus = pc.getAbilityModifiersMap().get("cha");
                saveDC = 8 + pc.getProficiencyBonus() + abilityBonus;
                break;
            case "cleric":
            case "druid":
            case "ranger":
                abilityBonus = pc.getAbilityModifiersMap().get("wis");
                saveDC = 8 + pc.getProficiencyBonus() + abilityBonus;
                break;

            default:
                saveDC = 0;
                break;

        }
        return saveDC;
    }

    public static void calculateHitDiceAndPoints(PlayerCharacter pc) {
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        List<String> hdList = new ArrayList<>();
        String clName = null;
        String archetype = null;
        boolean maxFirstLevel = true;
        int level = 0;
        int hitPoints = 0;
        int totalHP = 0;


        for (String key : levelMap.keySet()) {
            clName = key;
            for (String k : levelMap.get(key).keySet()) {
                level = levelMap.get(key).get(k);
            }

            CharacterClass chClass = ClassesManager.getCharacterClassByName(clName);
            hdList.add(level + "d" + String.valueOf(chClass.getHitDie()));

            if (maxFirstLevel) {
                hitPoints = chClass.getHitDie() + ((level - 1) * chClass.getAverageHP());
                maxFirstLevel = false;

            } else {
                hitPoints = chClass.getHitDie() + ((level - 1) * chClass.getAverageHP());

            }
            totalHP = totalHP + hitPoints;

        }
        totalHP = totalHP + (pc.getTotalLevel() * pc.getAbilityModifiersMap().get("con"));
        totalHP = (pc.getFeats().contains("Tough")) ? totalHP + (pc.getTotalLevel() * 2) : totalHP;

        pc.setMaxHitPoints(totalHP);
        pc.setCurrentHitPoints(totalHP);
        pc.setTempHitPoints(0);
        pc.setHitDice(aggregateHitDice(hdList));

    }


    public static List<String> aggregateHitDice(List<String> hitDice) {

        Map<String, Integer> hdMap = Stream.of(new Object[][]{
                {"d4", 0},
                {"d6", 0},
                {"d8", 0},
                {"d10", 0},
                {"d12", 0}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        int level = 0;
        int nDice = 0;
        String sides = null;
        String[] arr = null;

        for (String hd : hitDice) {
            arr = hd.split("d");
            nDice = Integer.parseInt(arr[0]);
            sides = arr[1];

            if (hdMap.containsKey(sides))
                nDice = nDice + hdMap.get(sides);

            hdMap.put("d" + sides, nDice);
        }

        List<String> hdList = new ArrayList<>();

        for (String key : hdMap.keySet()) {
            if (hdMap.get(key) > 0)
                hdList.add(hdMap.get(key) + key);
        }

        return hdList;
    }

    public static int calculateInitiative(PlayerCharacter pc) {
       return pc.getInitiative() + pc.getAbilityModifiersMap().get("dex");

    }
}

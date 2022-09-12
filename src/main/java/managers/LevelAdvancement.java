package managers;

import models.CharacterClass;
import models.ClassFeature;
import models.PlayerCharacter;
import utilities.DiceRoller;
import utilities.Randomizer;

import java.util.*;
import java.util.stream.Collectors;

public class LevelAdvancement {

    private static String clName;
    private static String archetype;
    private static int currentLevel;
    private static PlayerCharacter pc = null;

    public static PlayerCharacter addOneLevelForGenerator(PlayerCharacter inPC) {
        pc = inPC;
        //get class, archetype, current level
        getCurrentClassData();
        //get new class features
        addNewClassLevelFeatures();
        //calculate ASI, Feat
        generatePreferredASI();
        // get HD, calculate HP

        //add spells known or spellbook
        //recalculate prepared spells

        return pc;
    }

    public static void getCurrentClassData() {
        for (String key : pc.getLevelMap().keySet()) {
            clName = key;
            currentLevel = 0;
            for (String k : pc.getLevelMap().get(key).keySet()) {
                archetype = k;
                currentLevel = pc.getLevelMap().get(clName).get(archetype);
                break;
            }
            break;
        }
    }

    private static void calculateAddedHP(boolean aveHitPoints) {
        CharacterClass classObj = ClassesManager.getCharacterClassByName(clName);
        int hp = 0;

        if (aveHitPoints) {
            hp = pc.getMaxHitPoints() + classObj.getAverageHP() + pc.getAbilityModifiersMap().get("con");

        } else {

            switch (classObj.getHitDie()) {
                case 8:
                    hp = DiceRoller.roll1d8();
                    break;
                case 10:
                    hp = DiceRoller.roll1d10();
                    break;
                case 12:
                    hp = DiceRoller.roll1d12();
                    break;
                default:
                    hp = DiceRoller.roll1d6();
                    break;

            }
            hp = pc.getMaxHitPoints() + hp + pc.getAbilityModifiersMap().get("con");

        }

        pc.setMaxHitPoints(hp);
        pc.setCurrentHitPoints(hp);

    }

    private static void addNewClassLevelFeatures() {

        Set<String> featureSet = pc.getClassFeatures();
        List<ClassFeature> classFeatures = ClassFeaturesManager.getFeaturesByClassAndArchetype(clName, archetype, currentLevel + 1);
        Set<String> features = classFeatures.stream()
                .map(ClassFeature::getFeature)
                .collect(Collectors.toSet());

        featureSet.addAll(features);
        pc.setClassFeatures(featureSet);
    }

    private static void generatePreferredASI() {
        Set<String> feats = pc.getFeats();
        String bonusFeat = null;
        boolean asiApproved = false;
        int newLevel = currentLevel + 1;

        if (newLevel % 4 == 0 || newLevel == 19) {
            asiApproved = true;
        } else if (clName.equalsIgnoreCase("fighter") && (newLevel == 6 || newLevel == 14)) {
            asiApproved = true;
        }

        if (asiApproved) {
            if (DiceRoller.roll2d6()[2] < 7) {
                if (!applyASI()) {
                    bonusFeat = generateFeatByClass(clName, feats);
                    feats.add(bonusFeat);
                    System.out.println("Added " + bonusFeat + " Feat to feat list.");
                }
            } else {
                bonusFeat = generateFeatByClass(clName, feats);
                feats.add(bonusFeat);
                System.out.println("Added " + bonusFeat + " Feat to feat list.");
            }
        }

        if (bonusFeat != null) {
            feats.add(bonusFeat);
            pc.setFeats(feats);
        }
    }

    private static String generateFeatByClass(String clName, Set<String> featSet) {
        CharacterClass chClass = ClassesManager.getCharacterClassByName(clName);
        Set<String> rFeats = null;
        String feat = "junkfeat";

        if (DiceRoller.roll1d10() < 3) {
            rFeats = FeatsManager.getAllFeatNames();
        } else {
            rFeats = chClass.getRecommendedFeats();
        }

        do {
            feat = Randomizer.getRandomElement(rFeats);
            if (feat.equalsIgnoreCase("elemental adept"))
                feat = FeatsManager.refineElementalAdeptFeat(featSet);

        } while (featSet.contains(feat));

        return feat;
    }

    private static boolean applyASI() {
        CharacterClass classObj = ClassesManager.getCharacterClassByName(clName);
        List<String> abilityOrder = classObj.getAbilityOrder();

        int i = 0;
        for (String ability : abilityOrder) {

            switch (ability.toLowerCase()) {
                case "str":
                    if ((pc.getStrength() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setStrength(pc.getStrength() + 2);
                        System.out.println("Added 2 points to Strength");
                        return true;
                    } else if (pc.getStrength() < 20 && pc.isAbilityLimits()) {
                        pc.setStrength(pc.getStrength() + 1);
                        System.out.println("Added 1 point to Strength");
                        i++;
                    }
                    break;
                case "dex":
                    if ((pc.getDexterity() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setDexterity(pc.getDexterity() + 2);
                        System.out.println("Added 2 points to Dexterity");
                        return true;
                    } else if (pc.getDexterity() < 20 && pc.isAbilityLimits()) {
                        pc.setDexterity(pc.getDexterity() + 1);
                        System.out.println("Added 1 point to Dexterity");
                        i++;
                    }
                    break;
                case "con":
                    if ((pc.getConstitution() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setConstitution(pc.getConstitution() + 2);
                        System.out.println("Added 2 points to Constitution");
                        return true;
                    } else if (pc.getConstitution() < 20 && pc.isAbilityLimits()) {
                        pc.setConstitution(pc.getConstitution() + 1);
                        System.out.println("Added 1 point to Constitution");
                        i++;
                    }
                    break;
                case "int":
                    if ((pc.getIntelligence() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setIntelligence(pc.getIntelligence() + 2);
                        System.out.println("Added 2 points to Intelligence");
                        return true;
                    } else if (pc.getIntelligence() < 20 && pc.isAbilityLimits()) {
                        pc.setIntelligence(pc.getIntelligence() + 1);
                        System.out.println("Added 1 point to Intelligence");
                        i++;
                    }
                    break;
                case "wis":
                    if ((pc.getWisdom() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setWisdom(pc.getWisdom() + 2);
                        System.out.println("Added 2 points to Wisdom");
                        return true;
                    } else if (pc.getWisdom() < 20 && pc.isAbilityLimits()) {
                        pc.setWisdom(pc.getWisdom() + 1);
                        System.out.println("Added 1 point to Wisdom");
                        i++;
                    }
                    break;
                case "cha":
                    if ((pc.getCharisma() < 19 && pc.isAbilityLimits()) || !pc.isAbilityLimits()) {
                        pc.setCharisma(pc.getCharisma() + 2);
                        System.out.println("Added 2 points to Charisma");
                        return true;
                    } else if (pc.getCharisma() < 20 && pc.isAbilityLimits()) {
                        pc.setCharisma(pc.getCharisma() + 1);
                        System.out.println("Added 1 point to Charisma");
                        i++;
                    }
                    break;
                default:
                    break;
            }

            if (i == 2)
                return true;
        }
        return false;
    }
}

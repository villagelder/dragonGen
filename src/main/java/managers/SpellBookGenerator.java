package managers;

import data.wordmonger.Transfigure;
import models.*;
import org.apache.commons.lang3.StringUtils;
import utilities.DiceRoller;
import utilities.Randomizer;

import javax.imageio.plugins.tiff.TIFFTag;
import java.util.*;

public class SpellBookGenerator {

    //spellbook includes spells known
    public static SpellBook generateSpellBook(String caster, String school, int level) {
        caster = caster.toLowerCase();
        SpellBook spellBook = null;

        if (caster.equals("wizard") || caster.equals("eldritch knight") || caster.equals("arcane trickster"))
            spellBook = generateWizardSpellBook(caster, school, level);
        if (caster.equals("sorcerer") || caster.equals("bard")) spellBook = generateOtherSpells(caster, school, level);
        return spellBook;
    }

    private static SpellBook generateWizardSpellBook(String caster, String school, int level) {

        SpellBook spellBook = new SpellBook();
        if (school == null) {
            spellBook.setCaster(caster);
        } else {
            spellBook.setCaster(caster + "(" + school + ")");
        }

        String spellName = null;
        SpellsPerLevel spellsPerLevel = SpellsPerLevelManager.getSpellsPerLevelByClassAndLevel(caster, level);
        List<Integer> spellLevelsAvailable = new ArrayList<>();
        int spellsKnown = spellsPerLevel.getSpellsKnown();

        int spellPages = 0;
        Set<String> cantrips = generateSpellsBySpellLevel(caster, 2, 0);
        spellBook.setCantrips(cantrips);

        if (caster.equalsIgnoreCase("wizard") && school != null) {
            List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 0, 0);
            if (!spellList.isEmpty()) {
                Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                cantrips.add(spell.getSpellName());
            }
        }


        Set<String> levelOneSpells = null;
        if (spellsPerLevel.getLvl1() > 0) {
            levelOneSpells = generateSpellsBySpellLevel(caster, 2, 1);
            spellBook.setSpellsLevel1(levelOneSpells);
            spellPages = spellBook.getSpellsLevel1().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 1, 1);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelOneSpells.add(spell.getSpellName());
                }
            }
            if (!levelOneSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        }

        Set<String> levelTwoSpells = null;
        if (spellsPerLevel.getLvl2() > 0) {
            levelTwoSpells = generateSpellsBySpellLevel(caster, 1, 2);
            spellBook.setSpellsLevel2(levelTwoSpells);
            spellPages = spellPages + spellBook.getSpellsLevel2().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 2, 2);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelTwoSpells.add(spell.getSpellName());
                }
            }
            if (!levelTwoSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        }

        Set<String> levelThreeSpells = null;
        if (spellsPerLevel.getLvl3() > 0) {
            levelThreeSpells = generateSpellsBySpellLevel(caster, 1, 3);
            spellBook.setSpellsLevel3(levelThreeSpells);
            spellPages = spellPages + spellBook.getSpellsLevel3().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 3, 3);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelThreeSpells.add(spell.getSpellName());
                }
            }
            if (!levelThreeSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(3, 3, 3, 3)));
        }

        Set<String> levelFourSpells = null;
        if (spellsPerLevel.getLvl4() > 0) {
            levelFourSpells = generateSpellsBySpellLevel(caster, 1, 4);
            spellBook.setSpellsLevel4(levelFourSpells);
            spellPages = spellPages + spellBook.getSpellsLevel4().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 4, 4);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelFourSpells.add(spell.getSpellName());
                }
            }
            if (!levelFourSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(4, 4, 4)));
        }

        Set<String> levelFiveSpells = null;
        if (spellsPerLevel.getLvl5() > 0) {
            levelFiveSpells = generateSpellsBySpellLevel(caster, 1, 5);
            spellBook.setSpellsLevel5(levelFiveSpells);
            spellPages = spellPages + spellBook.getSpellsLevel5().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 5, 5);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelFiveSpells.add(spell.getSpellName());
                }
            }
            if (!levelFiveSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(5, 5, 5)));
        }

        Set<String> levelSixSpells = null;
        if (spellsPerLevel.getLvl6() > 0) {
            levelSixSpells = generateSpellsBySpellLevel(caster, 1, 6);
            spellBook.setSpellsLevel6(levelSixSpells);
            spellPages = spellPages + spellBook.getSpellsLevel6().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 6, 6);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelSixSpells.add(spell.getSpellName());
                }
            }
            if (!levelSixSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(6, 6)));
        }

        Set<String> levelSevenSpells = null;
        if (spellsPerLevel.getLvl7() > 0) {
            levelSevenSpells = generateSpellsBySpellLevel(caster, 1, 7);
            spellBook.setSpellsLevel7(levelSevenSpells);
            spellPages = spellPages + spellBook.getSpellsLevel7().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 7, 7);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelSevenSpells.add(spell.getSpellName());
                }
            }
            if (!levelSevenSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(7, 7)));
        }

        Set<String> levelEightSpells = null;
        if (spellsPerLevel.getLvl8() > 0) {
            levelEightSpells = generateSpellsBySpellLevel(caster, 1, 8);
            spellBook.setSpellsLevel8(levelEightSpells);
            spellPages = spellPages + spellBook.getSpellsLevel8().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 8, 8);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelEightSpells.add(spell.getSpellName());
                }
            }
            if (!levelEightSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(8)));
        }

        Set<String> levelNineSpells = null;
        if (spellsPerLevel.getLvl9() > 0) {
            levelNineSpells = generateSpellsBySpellLevel(caster, 1, 9);
            spellBook.setSpellsLevel9(levelNineSpells);
            spellPages = spellPages + spellBook.getSpellsLevel9().size();
            if (caster.equalsIgnoreCase("wizard") && school != null) {
                List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, 9, 9);
                if (!spellList.isEmpty()) {
                    Spell spell = (Spell) Randomizer.getRandomObject(spellList);
                    levelNineSpells.add(spell.getSpellName());
                }
            }
            if (!levelNineSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(9)));
        }

        while (spellPages < spellsKnown) {

            Collections.shuffle(spellLevelsAvailable);
            int spLevel = (int) Randomizer.getRandomObject(spellLevelsAvailable);

            switch (spLevel) {
                case 2:
                    levelTwoSpells = addSpellsBySpellLevel(levelTwoSpells, caster, 1, 2);
                    spellBook.setSpellsLevel2(levelTwoSpells);
                    spellPages++;
                    break;
                case 3:
                    levelThreeSpells = addSpellsBySpellLevel(levelThreeSpells, caster, 1, 3);
                    spellBook.setSpellsLevel3(levelThreeSpells);
                    spellPages++;
                    break;
                case 4:
                    levelFourSpells = addSpellsBySpellLevel(levelFourSpells, caster, 1, 4);
                    spellBook.setSpellsLevel4(levelFourSpells);
                    spellPages++;
                    break;
                case 5:
                    levelFiveSpells = addSpellsBySpellLevel(levelFiveSpells, caster, 1, 5);
                    spellBook.setSpellsLevel5(levelFiveSpells);
                    spellPages++;
                    break;
                case 6:
                    levelSixSpells = addSpellsBySpellLevel(levelSixSpells, caster, 1, 6);
                    spellBook.setSpellsLevel6(levelSixSpells);
                    spellPages++;
                    break;
                case 7:
                    levelSevenSpells = addSpellsBySpellLevel(levelSevenSpells, caster, 1, 7);
                    spellBook.setSpellsLevel7(levelSevenSpells);
                    spellPages++;
                    break;
                case 8:
                    levelEightSpells = addSpellsBySpellLevel(levelEightSpells, caster, 1, 8);
                    spellBook.setSpellsLevel8(levelEightSpells);
                    spellPages++;
                    break;
                case 9:
                    levelNineSpells = addSpellsBySpellLevel(levelNineSpells, caster, 1, 9);
                    spellBook.setSpellsLevel9(levelNineSpells);
                    spellPages++;
                    break;

                default:
                    levelOneSpells = addSpellsBySpellLevel(levelOneSpells, caster, 1, 1);
                    spellBook.setSpellsLevel1(levelOneSpells);
                    spellPages++;
                    break;

            }

        }
        return spellBook;

    }

    private static String getRandomSpellFromSchool(String caster, String school, int level) {
        List<Spell> spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, school, level, level);

        for (Spell sp : spellList)
            System.out.println(sp.getSpellName());

        //  String spell = Randomizer.getRandomElement(spells);
        return null;
    }

    private static SpellBook generateOtherSpells(String caster, String school, int level) {

        SpellBook spellBook = new SpellBook();
        SpellsPerLevel spellsPerLevel = SpellsPerLevelManager.getSpellsPerLevelByClassAndLevel(caster, level);
        List<Integer> spellLevelsAvailable = new ArrayList<>();

        int spellsKnown = spellsPerLevel.getSpellsKnown();

        int spellsLearned = 0;

        Set<String> cantrips = generateSpellsBySpellLevel(caster, spellsPerLevel.getCantrips(), 0);
        spellBook.setCantrips(cantrips);

        Set<String> levelOneSpells = generateSpellsBySpellLevel(caster, 2, 1);
        spellBook.setSpellsLevel1(levelOneSpells);
        if (!levelOneSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));

        Set<String> levelTwoSpells = new HashSet<>();
        if (spellsPerLevel.getLvl2() > 0) levelTwoSpells = generateSpellsBySpellLevel(caster, 1, 2);
        spellBook.setSpellsLevel2(levelTwoSpells);
        if (!levelTwoSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));

        Set<String> levelThreeSpells = new HashSet<>();
        if (spellsPerLevel.getLvl3() > 0) levelThreeSpells = generateSpellsBySpellLevel(caster, 1, 3);
        spellBook.setSpellsLevel3(levelThreeSpells);
        if (!levelThreeSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(3, 3, 3, 3)));

        Set<String> levelFourSpells = new HashSet<>();
        if (spellsPerLevel.getLvl4() > 0) levelFourSpells = generateSpellsBySpellLevel(caster, 1, 4);
        spellBook.setSpellsLevel4(levelFourSpells);
        if (!levelFourSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(4, 4, 4)));

        Set<String> levelFiveSpells = new HashSet<>();
        if (spellsPerLevel.getLvl5() > 0)
            levelFiveSpells = generateSpellsBySpellLevel(caster, 1, 5);
        spellBook.setSpellsLevel5(levelFiveSpells);
        if (!levelFiveSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(5, 5, 5)));

        Set<String> levelSixSpells = new HashSet<>();
        if (spellsPerLevel.getLvl6() > 0) levelSixSpells = generateSpellsBySpellLevel(caster, 1, 6);
        spellBook.setSpellsLevel6(levelSixSpells);
        if (!levelSixSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(6, 6)));

        Set<String> levelSevenSpells = new HashSet<>();
        if (spellsPerLevel.getLvl7() > 0) levelSevenSpells = generateSpellsBySpellLevel(caster, 1, 7);
        spellBook.setSpellsLevel7(levelSevenSpells);
        if (!levelSevenSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(7, 7)));


        Set<String> levelEightSpells = new HashSet<>();
        if (spellsPerLevel.getLvl8() > 0) levelEightSpells = generateSpellsBySpellLevel(caster, 1, 8);
        spellBook.setSpellsLevel8(levelEightSpells);
        if (!levelEightSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(8)));

        Set<String> levelNineSpells = new HashSet<>();
        if (spellsPerLevel.getLvl9() > 0) levelNineSpells = generateSpellsBySpellLevel(caster, 1, 9);
        spellBook.setSpellsLevel9(levelNineSpells);
        if (!levelNineSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(9)));

        spellsLearned = levelOneSpells.size() + levelTwoSpells.size() + levelThreeSpells.size() + levelFourSpells.size() + levelFiveSpells.size() +
                levelSixSpells.size() + levelSevenSpells.size() + levelEightSpells.size() + levelNineSpells.size();

        while (spellsLearned < spellsKnown) {

            Collections.shuffle(spellLevelsAvailable);
            int spLevel = (int) Randomizer.getRandomObject(spellLevelsAvailable);

            switch (spLevel) {
                case 2:
                    levelTwoSpells = addSpellsBySpellLevel(levelTwoSpells, caster, 1, 2);
                    spellBook.setSpellsLevel2(levelTwoSpells);
                    spellsLearned++;
                    break;
                case 3:
                    levelThreeSpells = addSpellsBySpellLevel(levelThreeSpells, caster, 1, 3);
                    spellBook.setSpellsLevel3(levelThreeSpells);
                    spellsLearned++;
                    break;
                case 4:
                    levelFourSpells = addSpellsBySpellLevel(levelFourSpells, caster, 1, 4);
                    spellBook.setSpellsLevel4(levelFourSpells);
                    spellsLearned++;
                    break;
                case 5:
                    levelFiveSpells = addSpellsBySpellLevel(levelFiveSpells, caster, 1, 5);
                    spellBook.setSpellsLevel5(levelFiveSpells);
                    spellsLearned++;
                    break;
                case 6:
                    levelSixSpells = addSpellsBySpellLevel(levelSixSpells, caster, 1, 6);
                    spellBook.setSpellsLevel6(levelSixSpells);
                    spellsLearned++;
                    break;
                case 7:
                    levelSevenSpells = addSpellsBySpellLevel(levelSevenSpells, caster, 1, 7);
                    spellBook.setSpellsLevel7(levelSevenSpells);
                    spellsLearned++;
                    break;
                case 8:
                    levelEightSpells = addSpellsBySpellLevel(levelEightSpells, caster, 1, 8);
                    spellBook.setSpellsLevel8(levelEightSpells);
                    spellsLearned++;
                    break;
                case 9:
                    levelNineSpells = addSpellsBySpellLevel(levelNineSpells, caster, 1, 9);
                    spellBook.setSpellsLevel9(levelNineSpells);
                    spellsLearned++;
                    break;

                default:
                    levelOneSpells = addSpellsBySpellLevel(levelOneSpells, caster, 1, 1);
                    spellBook.setSpellsLevel1(levelOneSpells);
                    spellsLearned++;
                    break;

            }

        }
        return spellBook;

    }

    public static Map<Integer, Set<String>> generatePreparedSpells(SpellBook spellBook, String caster, String school, int level, int abilityMod) {
        if (spellBook != null)
            return prepareFromSpellBook(spellBook, caster, school, level, abilityMod);

        return prepareFromClassSpells(caster, school, level, abilityMod);
    }

    public static Map<Integer, Set<String>> prepareFromClassSpells(String caster, String school, int level, int abilityMod) {
        Map<Integer, Set<String>> preparedSpells = new HashMap<>();
        List<Integer> spellLevelsAvailable = new ArrayList<>();
        SpellsPerLevel spellsPerLevel = SpellsPerLevelManager.getSpellsPerLevelByClassAndLevel(caster, level);

        int spellsPrepped = (level + abilityMod > 0) ? level + abilityMod : 1;

        if (caster.equals("paladin") || caster.equals("ranger")) {
            spellsPrepped = (level / 2 + abilityMod > 0) ? level + abilityMod : 1;
        }
        int spellsReceived = 0;

        Set<String> cantrips = generateSpellsBySpellLevel(caster, spellsPerLevel.getCantrips(), 0);
        preparedSpells.put(0, cantrips);

        Set<String> levelOneSpells = generateSpellsBySpellLevel(caster, 2, 1);
        preparedSpells.put(1, levelOneSpells);
        if (!levelOneSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));

        Set<String> levelTwoSpells = new HashSet<>();
        if (spellsPerLevel.getLvl2() > 0) levelTwoSpells = generateSpellsBySpellLevel(caster, 1, 2);
        preparedSpells.put(2, levelTwoSpells);
        if (!levelTwoSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));

        Set<String> levelThreeSpells = new HashSet<>();
        if (spellsPerLevel.getLvl3() > 0) levelThreeSpells = generateSpellsBySpellLevel(caster, 1, 3);
        preparedSpells.put(3, levelThreeSpells);
        if (!levelThreeSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(3, 3, 3, 3)));

        Set<String> levelFourSpells = new HashSet<>();
        if (spellsPerLevel.getLvl4() > 0) levelFourSpells = generateSpellsBySpellLevel(caster, 1, 4);
        preparedSpells.put(4, levelFourSpells);
        if (!levelFourSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(4, 4, 4)));

        Set<String> levelFiveSpells = new HashSet<>();
        if (spellsPerLevel.getLvl5() > 0) levelFiveSpells = generateSpellsBySpellLevel(caster, 1, 5);
        preparedSpells.put(5, levelFiveSpells);
        if (!levelFiveSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(5, 5, 5)));

        Set<String> levelSixSpells = new HashSet<>();
        if (spellsPerLevel.getLvl6() > 0) levelSixSpells = generateSpellsBySpellLevel(caster, 1, 6);
        preparedSpells.put(6, levelSixSpells);
        if (!levelSixSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(6, 6)));

        Set<String> levelSevenSpells = new HashSet<>();
        if (spellsPerLevel.getLvl7() > 0) levelSevenSpells = generateSpellsBySpellLevel(caster, 1, 7);
        preparedSpells.put(7, levelSevenSpells);
        if (!levelSevenSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(7, 7)));


        Set<String> levelEightSpells = new HashSet<>();
        if (spellsPerLevel.getLvl8() > 0) levelEightSpells = generateSpellsBySpellLevel(caster, 1, 8);
        preparedSpells.put(8, levelEightSpells);
        if (!levelEightSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(8)));

        Set<String> levelNineSpells = new HashSet<>();
        if (spellsPerLevel.getLvl9() > 0) levelNineSpells = generateSpellsBySpellLevel(caster, 1, 9);
        preparedSpells.put(9, levelNineSpells);
        if (!levelNineSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(9)));

        spellsReceived = levelOneSpells.size() + levelTwoSpells.size() + levelThreeSpells.size() + levelFourSpells.size() + levelFiveSpells.size() +
                levelSixSpells.size() + levelSevenSpells.size() + levelEightSpells.size() + levelNineSpells.size();

        while (spellsReceived < spellsPrepped) {

            Collections.shuffle(spellLevelsAvailable);
            int spLevel = (int) Randomizer.getRandomObject(spellLevelsAvailable);

            switch (spLevel) {
                case 2:
                    levelTwoSpells = addSpellsBySpellLevel(levelTwoSpells, caster, 1, 2);
                    preparedSpells.put(2, levelTwoSpells);
                    spellsReceived++;
                    break;
                case 3:
                    levelThreeSpells = addSpellsBySpellLevel(levelThreeSpells, caster, 1, 3);
                    preparedSpells.put(3, levelThreeSpells);
                    spellsReceived++;
                    break;
                case 4:
                    levelFourSpells = addSpellsBySpellLevel(levelFourSpells, caster, 1, 4);
                    preparedSpells.put(4, levelFourSpells);
                    spellsReceived++;
                    break;
                case 5:
                    levelFiveSpells = addSpellsBySpellLevel(levelFiveSpells, caster, 1, 5);
                    preparedSpells.put(5, levelFiveSpells);
                    spellsReceived++;
                    break;
                case 6:
                    levelSixSpells = addSpellsBySpellLevel(levelSixSpells, caster, 1, 6);
                    preparedSpells.put(6, levelSixSpells);
                    spellsReceived++;
                    break;
                case 7:
                    levelSevenSpells = addSpellsBySpellLevel(levelSevenSpells, caster, 1, 7);
                    preparedSpells.put(7, levelSevenSpells);
                    spellsReceived++;
                    break;
                case 8:
                    levelEightSpells = addSpellsBySpellLevel(levelEightSpells, caster, 1, 8);
                    preparedSpells.put(8, levelEightSpells);
                    spellsReceived++;
                    break;
                case 9:
                    levelNineSpells = addSpellsBySpellLevel(levelNineSpells, caster, 1, 9);
                    preparedSpells.put(9, levelNineSpells);
                    spellsReceived++;
                    break;

                default:
                    levelOneSpells = addSpellsBySpellLevel(levelOneSpells, caster, 1, 1);
                    preparedSpells.put(1, levelOneSpells);
                    spellsReceived++;
                    break;

            }

        }
        return preparedSpells;

    }

    public static Map<Integer, Set<String>> prepareFromSpellBook(SpellBook spellBook, String caster, String school, int level, int abilityMod) {
        Map<Integer, Set<String>> preparedSpells = new HashMap<>();
        List<Integer> spellLevelsAvailable = new ArrayList<>();
        SpellsPerLevel spellsPerLevel = SpellsPerLevelManager.getSpellsPerLevelByClassAndLevel(caster, level);

        int spellsToPrepare = level + abilityMod;

        int spellsReadied = 0;

        preparedSpells.put(0, spellBook.getCantrips());

        Set<String> levelOneSpells = prepareSpellsFromSet(spellBook.getSpellsLevel1(), 1);
        preparedSpells.put(1, levelOneSpells);
        spellsReadied++;
        if (!levelOneSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));

        Set<String> levelTwoSpells = new HashSet<>();
        if (spellsPerLevel.getLvl2() > 0 && spellsReadied < spellsToPrepare) {
            levelTwoSpells = prepareSpellsFromSet(spellBook.getSpellsLevel2(), 1);
            preparedSpells.put(2, levelTwoSpells);
            spellsReadied++;
        }
        if (!levelTwoSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));

        Set<String> levelThreeSpells = new HashSet<>();
        if (spellsPerLevel.getLvl3() > 0 && spellsReadied < spellsToPrepare) {
            levelThreeSpells = prepareSpellsFromSet(spellBook.getSpellsLevel3(), 1);
            preparedSpells.put(3, levelThreeSpells);
            spellsReadied++;
        }
        if (!levelThreeSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(3, 3, 3, 3)));

        Set<String> levelFourSpells = new HashSet<>();
        if (spellsPerLevel.getLvl4() > 0 && spellsReadied < spellsToPrepare) {
            levelFourSpells = prepareSpellsFromSet(spellBook.getSpellsLevel4(), 1);
            preparedSpells.put(4, levelFourSpells);
            spellsReadied++;
        }
        if (!levelFourSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(4, 4, 4)));

        Set<String> levelFiveSpells = new HashSet<>();
        if (spellsPerLevel.getLvl5() > 0 && spellsReadied < spellsToPrepare) {
            levelFiveSpells = prepareSpellsFromSet(spellBook.getSpellsLevel5(), 1);
            preparedSpells.put(5, levelFiveSpells);
            spellsReadied++;
        }
        if (!levelFiveSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(5, 5, 5)));

        Set<String> levelSixSpells = new HashSet<>();
        if (spellsPerLevel.getLvl6() > 0 && spellsReadied < spellsToPrepare) {
            levelSixSpells = prepareSpellsFromSet(spellBook.getSpellsLevel6(), 1);
            preparedSpells.put(6, levelSixSpells);
            spellsReadied++;
        }
        if (!levelSixSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(6, 6)));

        Set<String> levelSevenSpells = new HashSet<>();
        if (spellsPerLevel.getLvl7() > 0 && spellsReadied < spellsToPrepare) {
            levelSevenSpells = prepareSpellsFromSet(spellBook.getSpellsLevel7(), 1);
            preparedSpells.put(7, levelSevenSpells);
            spellsReadied++;
        }
        if (!levelSevenSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(7, 7)));

        Set<String> levelEightSpells = new HashSet<>();
        if (spellsPerLevel.getLvl8() > 0 && spellsReadied < spellsToPrepare) {
            levelEightSpells = prepareSpellsFromSet(spellBook.getSpellsLevel8(), 1);
            preparedSpells.put(8, levelEightSpells);
            spellsReadied++;
        }
        if (!levelEightSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(8)));

        Set<String> levelNineSpells = new HashSet<>();
        if (spellsPerLevel.getLvl9() > 0 && spellsReadied < spellsToPrepare) {
            levelNineSpells = prepareSpellsFromSet(spellBook.getSpellsLevel9(), 1);
            preparedSpells.put(9, levelNineSpells);
            spellsReadied++;
        }
        if (!levelNineSpells.isEmpty()) spellLevelsAvailable.addAll(new ArrayList<>(Arrays.asList(9)));

        while (spellsReadied < spellsToPrepare) {

            Collections.shuffle(spellLevelsAvailable);
            int spLevel = (int) Randomizer.getRandomObject(spellLevelsAvailable);

            Set<String> moreSpells = new HashSet<>();

            switch (spLevel) {
                case 2:
                    if (preparedSpells.get(2).size() == spellBook.getSpellsLevel2().size()) break;
                    preparedSpells.put(2, addOneSpellFromSet(spellBook.getSpellsLevel2(), preparedSpells.get(2)));
                    spellsReadied++;
                    break;
                case 3:
                    if (preparedSpells.get(3).size() == spellBook.getSpellsLevel3().size()) break;
                    preparedSpells.put(3, addOneSpellFromSet(spellBook.getSpellsLevel3(), preparedSpells.get(3)));
                    spellsReadied++;
                    break;
                case 4:
                    if (preparedSpells.get(4).size() == spellBook.getSpellsLevel4().size()) break;
                    preparedSpells.put(4, addOneSpellFromSet(spellBook.getSpellsLevel4(), preparedSpells.get(4)));
                    spellsReadied++;
                    break;
                case 5:
                    if (preparedSpells.get(5).size() == spellBook.getSpellsLevel5().size()) break;
                    preparedSpells.put(5, addOneSpellFromSet(spellBook.getSpellsLevel5(), preparedSpells.get(5)));
                    spellsReadied++;
                    break;
                case 6:
                    if (preparedSpells.get(6).size() == spellBook.getSpellsLevel6().size()) break;
                    preparedSpells.put(6, addOneSpellFromSet(spellBook.getSpellsLevel6(), preparedSpells.get(6)));
                    spellsReadied++;
                    break;
                case 7:
                    if (preparedSpells.get(7).size() == spellBook.getSpellsLevel7().size()) break;
                    preparedSpells.put(7, addOneSpellFromSet(spellBook.getSpellsLevel7(), preparedSpells.get(7)));
                    spellsReadied++;
                    break;
                case 8:
                    if (preparedSpells.get(8).size() == spellBook.getSpellsLevel8().size()) break;
                    preparedSpells.put(8, addOneSpellFromSet(spellBook.getSpellsLevel8(), preparedSpells.get(8)));
                    spellsReadied++;
                    break;
                case 9:
                    if (preparedSpells.get(9).size() == spellBook.getSpellsLevel9().size()) break;
                    preparedSpells.put(9, addOneSpellFromSet(spellBook.getSpellsLevel9(), preparedSpells.get(9)));
                    spellsReadied++;
                    break;

                default:
                    if (preparedSpells.get(1).size() == spellBook.getSpellsLevel1().size()) break;
                    preparedSpells.put(1, addOneSpellFromSet(spellBook.getSpellsLevel1(), preparedSpells.get(1)));
                    spellsReadied++;
                    break;

            }

        }
        return preparedSpells;

    }

    private static Set<String> addOneSpellFromSet(Set<String> spellList, Set<String> currentSpells) {
        int sz = currentSpells.size() + 1;
        Set<String> spells = currentSpells;

        while (spells.size() < sz)
            spells.add(Randomizer.getRandomElement(spellList));

        return spells;
    }

    private static Set<String> prepareSpellsFromSet(Set<String> spellList, int number) {
        Set<String> spells = new HashSet<>();

        while (spells.size() < number) spells.add(Randomizer.getRandomElement(spellList));

        return spells;

    }

    private static Set<String> generateSpellsBySpellLevel(String caster, int number, int spellLevel) {
        List<Spell> spellList = null;
        String clName = caster;

        if (caster.equals("eldritch knight")) {
            clName = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(clName, "abjuration", spellLevel, spellLevel);
            spellList.addAll(SpellManager.getSpellsByClassSchoolAndLevels(clName, "evocation", spellLevel, spellLevel));

        } else if (caster.equals("arcane trickster")) {
            clName = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(clName, "enchantment", spellLevel, spellLevel);
            spellList.addAll(SpellManager.getSpellsByClassSchoolAndLevels(clName, "illusion", spellLevel, spellLevel));
        } else {
            clName = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(clName, null, spellLevel, spellLevel);
        }

        Set<String> spells = new HashSet<>();

        while (spells.size() < number) {
            if ((caster.equals("arcane trickster") || caster.equals("eldritch knight")) && spellLevel == 0 && spells.size() == 2)
                break;
            Spell spell = (Spell) Randomizer.getRandomObject(spellList);
            spells.add(spell.getSpellName());

        }

        spellList = SpellManager.getSpellsByClassSchoolAndLevels(clName, null, spellLevel, spellLevel);
        while ((caster.equals("arcane trickster") || caster.equals("eldritch knight")) && spells.size() < number) {
            Spell spell = (Spell) Randomizer.getRandomObject(spellList);
            spells.add(spell.getSpellName());
        }
        return spells;
    }

    private static Set<String> addSpellsBySpellLevel(Set<String> currentSpells, String caster, int number, int spellLevel) {
        List<Spell> spellList = null;

        if (caster.equals("eldritch knight")) {
            caster = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, "abjuration", spellLevel, spellLevel);
            spellList.addAll(SpellManager.getSpellsByClassSchoolAndLevels(caster, "evocation", spellLevel, spellLevel));
        } else if (caster.equals("arcane trickster")) {
            caster = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, "enchantment", spellLevel, spellLevel);
            spellList.addAll(SpellManager.getSpellsByClassSchoolAndLevels(caster, "illusion", spellLevel, spellLevel));
        } else {
            caster = "wizard";
            spellList = SpellManager.getSpellsByClassSchoolAndLevels(caster, null, spellLevel, spellLevel);
        }
        number = number + currentSpells.size();

        while (currentSpells.size() < number) {
            Spell spell = (Spell) Randomizer.getRandomObject(spellList);
            currentSpells.add(spell.getSpellName());
        }

        return currentSpells;
    }

    public static String createSpellBookName(String school) {

        if (school == null)
            school = Randomizer.getRandomElement(OnomasticonManager.getAllSubjectsInFile("books"));

        String title = null;
        String desc1 = OnomasticonManager.getRandomDescriptorBySubject("books", school);
        String desc2 = OnomasticonManager.getRandomDescriptorBySubject("books", school);
        String sub1 = OnomasticonManager.getRandomSubstantiveBySubject("books", school);
        String sub2 = OnomasticonManager.getRandomSubstantiveBySubject("books", school);
        String meto1 = OnomasticonManager.getRandomMetonymBySubject("books", school);
        String act1 = OnomasticonManager.getRandomActionBySubject("books", school);
        String act2 = OnomasticonManager.getRandomActionBySubject("books", school);
        String book = OnomasticonManager.getRandomMetonymBySubject("books", "book");
        String complicated = OnomasticonManager.getRandomMetonymBySubject("books", "complicated");
        String monster = OnomasticonManager.getRandomMetonymBySubject("books", "monster");
        String actioner = Transfigure.getActionMaker(act1);
        String pedag = OnomasticonManager.getRandomSubstantiveBySubject("books", "pedagogy");

        while (desc1.equals(desc2))
            desc2 = OnomasticonManager.getRandomDescriptorBySubject("books", school);

        while (sub1.equals(sub2))
            sub2 = OnomasticonManager.getRandomMetonymBySubject("books", school);

        while (act1.equals(act2))
            act2 = OnomasticonManager.getRandomActionBySubject("books", school);

        switch (DiceRoller.roll1d8()) {
            case 2:
                title = "The " + book + " of the " + sub2 + " and " + Transfigure.getPluralNoun(meto1);
                break;
            case 3:
                title = "The " + actioner;
                break;
            case 4:
                title = "The " + desc2 + " " + actioner;
                break;
            case 5:
                if (DiceRoller.roll1d2() < 2) {
                    title = "When " + Transfigure.getActiveVerb(act1) + " leads to " + Transfigure.getPluralNoun(sub2);
                } else {
                    title = "How to " + act1 + " with " + meto1;
                }
                break;
            case 6:
                if (DiceRoller.roll1d2() < 2) {
                    title = "The " + monster + " " + actioner;
                } else {
                    title = "The " + Transfigure.getPluralNoun(monster) + " of " + meto1;
                }
                break;

            default:
                if (DiceRoller.roll1d2() < 2) {
                    title = "The " + desc2 + " and the " + desc1;
                } else {
                    title = "The " + pedag + " of " + complicated + " " + meto1;
                }
                break;

        }
        title = Transfigure.titleCase(title);
        return title;

    }

}

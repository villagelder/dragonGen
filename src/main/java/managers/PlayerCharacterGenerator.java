package managers;

import data.AbilityScoreGenerator;
import utilities.DiceRoller;
import models.*;
import org.apache.commons.lang3.StringUtils;
import utilities.Randomizer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerCharacterGenerator {

    private static PlayerCharacter pc;
    private static Race raceObj;
    private static CharacterClass classObj;
    private static Background backgroundObj;


    //input race, character class, gender, alignment, and level (1-20)
    //Strings nullable
    public static PlayerCharacter generateRandomPC(String race, String chClass, String gender, String alignment, int level, boolean takeBonusFeat, boolean abilityLimits) {

        classObj = ClassesManager.getRandomClass(chClass);
        System.out.println("CLASS: " + classObj.getClassName());

        backgroundObj = BackgroundsManager.getRandomBackgroundWeighted(classObj);
        System.out.println("BACKGROUND: " + backgroundObj.getBackground());

        pc = PlayerCharacterManager.createNewPC("Z2U5RR27HSPJ08ZQ2X070Y0W27B8");
        pc.setAbilityLimits(abilityLimits);

        generateRaceData(race, gender, takeBonusFeat);
        generateBackground(alignment);
        generateClassData(chClass, level);
        generateAbilityScores();
        addRacialBonuses();
        generateRandomFeatsAndASI(takeBonusFeat);
        generateStartingEquipment(classObj, getArchetype(classObj.getClassName()));
        calculateFields();

        return pc;
    }

    private static void generateRandomFeatsAndASI(boolean takeBonusFeat) {
        Set<String> feats = new HashSet<>();

        //level one feat
        if (takeBonusFeat || (raceObj.getRaceName().equalsIgnoreCase("human") && raceObj.getSubrace().equalsIgnoreCase("variant"))) {
            String bonusFeat = Randomizer.getRandomElement(classObj.getRecommendedFeats());
            if (bonusFeat.equalsIgnoreCase("elemental adept")) {
                bonusFeat = FeatsManager.refineElementalAdeptFeat(feats);
            }
            feats.add(bonusFeat);
        }

        //more feats for levels 4, 8, 12, 16, 19
        int numberASI = 0;
        Map<String, HashMap<String, Integer>> levelMap = pc.getLevelMap();
        for (String key : levelMap.keySet()) {
            String clName = key;
            for (String k : levelMap.get(key).keySet()) {
                int classLevel = levelMap.get(key).get(k);
                if (classLevel < 19) {
                    numberASI = numberASI + (classLevel / 4);

                } else if (classLevel > 18) {
                    numberASI = 5;
                }

                if (clName.equalsIgnoreCase("fighter") && classLevel > 5)
                    numberASI = numberASI + (classLevel - 2) / 4;

                while (numberASI > 0) {

                    if (DiceRoller.roll2d6()[2] < 7) {
                        if (!applyASI()) {
                            String ft = generateFeatByClass(clName, feats);
                            feats.add(ft);
                            System.out.println("Added " + ft + " Feat to feat list.");
                        }
                    } else {
                        String ft = generateFeatByClass(clName, feats);
                        feats.add(ft);
                        System.out.println("Added " + ft + " Feat to feat list.");
                    }

                    numberASI--;
                }

            }

        }

        pc.setFeats(feats);

        if (pc.getFeats() != null)
            applyFeats();

        calculateAbilityModifiers();

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

//    public static void setMagicInitiateSpells(Set<String> cantrips) {
//        Set<String> cantripClasses = new HashSet<>(Arrays.asList("Warlock", "Wizard", "Bard", "Druid", "Sorcerer", "Cleric"));
//        String castingClass = Randomizer.getRandomElement(cantripClasses);
//        List<String> cantripList = SpellManager.getSpellsByClassSchoolAndLevels(castingClass, null, 0, 0).stream()
//                .map(Spell::getSpellName)
//                .collect(Collectors.toList());
//
//        String cantrip = null;
//
//        for (int c = 0; c < 2; c++) {
//            do {
//                cantrip = Randomizer.getRandomElement(cantripList);
//            } while (cantrips.contains(cantrip));
//        }
//
//
//    }

    public static Set<Feat> applyFeats() {
        Set<Feat> flist = pc.getFeats().stream()
                .map(f -> {
                    Feat featObj = FeatsManager.getFeatByName(f);
                    return featObj;
                })
                .collect(Collectors.toSet());

        for (Feat featObj : flist) {

            if (featObj.getAbilityOptions() != null)
                applyFeatAbilityBonus(featObj);

            pc.setSpeed(pc.getSpeed() + featObj.getAddedSpeed());
            Set<String> resistanceList = pc.getResistances();
            resistanceList.addAll(featObj.getResistances());
            pc.setResistances(resistanceList);
            pc.setInitiative(pc.getInitiative() + featObj.getInitiative());
            //Weapon Proficiencies from feats
            Set<String> wpnProfs = pc.getWeaponProfs();
            if (featObj.getWeaponProfs() != null)
                wpnProfs.addAll(featObj.getWeaponProfs());
            //Armor proficiencies from feats
            Set<String> armorProfs = pc.getArmorProfs();
            armorProfs.addAll(featObj.getArmorProfs());

            if (featObj.getName().equalsIgnoreCase("linguist"))
                pc.setLanguages(FeatsManager.refineLinguistFeat(pc.getLanguages()));
        }
        return flist;
    }

    private static void applyFeatAbilityBonus(Feat featObj) {
        Set<String> abilities = featObj.getAbilityOptions();
        int abilityScore = 0;


        for (String ability : abilities) {

            switch (ability.toLowerCase().substring(0, 3)) {
                case "str":
                    abilityScore = pc.getStrength();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setStrength(abilityScore + 1);
                        return;
                    }
                    break;

                case "dex":
                    abilityScore = pc.getDexterity();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setDexterity(abilityScore + 1);
                        return;
                    }
                    break;

                case "con":
                    abilityScore = pc.getConstitution();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setConstitution(abilityScore + 1);
                        return;
                    }
                    break;

                case "int":
                    abilityScore = pc.getIntelligence();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setIntelligence(abilityScore + 1);
                        return;
                    }
                    break;

                case "wis":
                    abilityScore = pc.getWisdom();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setWisdom(abilityScore + 1);
                        return;
                    }
                    break;

                case "cha":
                    abilityScore = pc.getCharisma();
                    if ((pc.isAbilityLimits() && abilityScore < 20) || !pc.isAbilityLimits()) {
                        pc.setCharisma(abilityScore + 1);
                    }
                    break;

                default:
                    break;
            }
        }
    }

    private static void calculateFields() {

        //total level
        pc.setTotalLevel(PlayerCharacterManager.calculateTotalLevel(pc));
        //proficiency bonus
        pc.setProficiencyBonus(PlayerCharacterManager.calculateProficiencyBonus(pc.getTotalLevel()));
        //saving throw adjustments
        calculateSaves();
        //skill check bonuses
        pc.setSkillCheckBonuses(PlayerCharacterManager.calculateSkillCheckModifiers(pc));
        //passive skills
        pc.setPassiveSkills(PlayerCharacterManager.calculatePassiveSkills(pc));
        //number of attacks
        pc.setNumberOfAttacks(PlayerCharacterManager.calculateNumberOfAttacks(pc));
        //melee attack
        pc.setMeleeAttackBonus(pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("str"));
        //ranged attack
        pc.setRangedAttackBonus(pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("dex"));
        //unarmed attack
        pc.setUnarmedAttackBonus(PlayerCharacterManager.calculateUnarmedAttack(pc));
        //spell DC
        pc.setSpellDC(PlayerCharacterManager.calculateSpellSaveDC(pc));
        //set hit dice and hit points
        PlayerCharacterManager.calculateHitDiceAndPoints(pc);
        pc.setInitiative(PlayerCharacterManager.calculateInitiative(pc));

    }


    private static void calculateSaves() {
        Set<String> saveProfs = pc.getSavingThrowProfs();

        int strSave = saveProfs.contains("Strength") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("str") : pc.getAbilityModifiersMap().get("str");
        pc.setStrengthSave(strSave);
        int dexSave = saveProfs.contains("Dexterity") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("dex") : pc.getAbilityModifiersMap().get("dex");
        pc.setDexteritySave(dexSave);
        int conSave = saveProfs.contains("Constitution") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("con") : pc.getAbilityModifiersMap().get("con");
        pc.setConstitutionSave(conSave);
        int intSave = saveProfs.contains("Intelligence") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("int") : pc.getAbilityModifiersMap().get("int");
        pc.setIntelligenceSave(intSave);
        int wisSave = saveProfs.contains("Wisdom") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("wis") : pc.getAbilityModifiersMap().get("wis");
        pc.setWisdomSave(wisSave);
        int chaSave = saveProfs.contains("Charisma") ? pc.getProficiencyBonus() + pc.getAbilityModifiersMap().get("cha") : pc.getAbilityModifiersMap().get("cha");
        pc.setCharismaSave(chaSave);

    }

    private static void calculateAbilityModifiers() {
        pc.setAbilityModifiersMap(PlayerCharacterManager.calculateAbilityModifiers(pc));

    }

    private static void generateStartingEquipment(CharacterClass characterClass, String archetype) {
        Map<String, Integer> inventory = ClassesManager.generateStartingEquipment(characterClass);
        archetype = archetype.toLowerCase();

        switch (archetype) {

            case "death domain":
                inventory.remove("Mace");
                inventory.put("Warhammer", 1);
                break;
            case "life domain":
                inventory.remove("Leather Armor");
                inventory.remove("Scale Mail");
                inventory.put("Chain Mail", 1);
                break;
            case "tempest domain":
            case "war domain":
                inventory.remove("Mace");
                inventory.put("Warhammer", 1);
                inventory.remove("Leather Armor");
                inventory.remove("Scale Mail");
                inventory.put("Chain Mail", 1);
                break;
            default:
                break;

        }

        pc.setInventory(inventory);
        equipArmor();
        setUnarmoredArmorClass();
    }

    private static void equipArmor() {
        Armor armour = null;
        Armor shield = null;
        Set<String> inventory = pc.getInventory().keySet();

        for (String item : inventory) {
            Armor armor = ArmorManager.getArmorByName(item);
            if (armor != null && !armor.getProficiency().equalsIgnoreCase("shield")) {
                armour = armor;
                pc.setArmorEquipped(armor.getArmorName());
            } else if (armor != null && armor.getProficiency().equalsIgnoreCase("shield")) {
                pc.setShieldEquipped(armor.getArmorName());
                shield = armor;
            } else {
                continue;
            }
        }

        pc.setArmorClass(PlayerCharacterManager.calculateArmorClass(armour, shield, pc.getAbilityModifiersMap().get("dex")));

    }

    public static void setUnarmoredArmorClass() {
        int dexBonus = pc.getAbilityModifiersMap().get("dex");
        int conBonus = pc.getAbilityModifiersMap().get("con");
        int wisBonus = pc.getAbilityModifiersMap().get("wis");
        pc.setUnarmoredArmorClass(PlayerCharacterManager.calculateUnarmoredAC(classObj.getClassName(), dexBonus, conBonus, wisBonus));
    }

    public static String getArchetype(String clName) {
        String archetype = "Base";

        Optional<String> archetypeKey = pc.getLevelMap().get(clName).keySet().stream().findFirst();
        if (archetypeKey.isPresent())
            archetype = archetypeKey.get();

        return archetype;
    }

    private static void generateLanguages() {
        Set<String> raceLanguages = raceObj.getLanguages();
        Set<String> languages = new HashSet<>(raceLanguages);

        String archetype = "Draconic Bloodline";//getArchetype(classObj.getClassName());
        List<ClassFeature> classFeatureList = ClassFeaturesManager.getFeaturesByClassAndArchetype(classObj.getClassName(), archetype, 1);

        for (ClassFeature clf : classFeatureList)
            languages.addAll(clf.getBonusLanguages());

        int numLangs = languages.size() + backgroundObj.getBonuslangs() + raceObj.getBonuslang();
        Set<String> languageList = LanguageManager.getAllLanguagesList();

        if (numLangs > raceLanguages.size()) {
            do {
                languages.add(Randomizer.getRandomElement(languageList));

            } while (languages.size() < numLangs);
        }

        pc.setLanguages(languages);
    }

    private static void generateBackground(String alignment) {
        Set<String> tempSet = new HashSet<>();
        pc.setBackground(backgroundObj.getBackground());
        Personality personality = PersonalityManager.getPersonalityByBackground(pc.getBackground());

        generateAlignment(alignment);


        //traits
        do {
            tempSet.add(Randomizer.getRandomElement(personality.getTraits()));
        }
        while (tempSet.size() < 2);
        pc.setTraits(tempSet);

        //ideals
        tempSet = new HashSet<>();
        tempSet.add(Randomizer.getRandomElement(personality.getIdeals()));
        pc.setIdeals(tempSet);


        //bonds
        tempSet = new HashSet<>();
        tempSet.add(Randomizer.getRandomElement(personality.getBonds()));
        pc.setBonds(tempSet);

        //flaws
        tempSet = new HashSet<>();
        tempSet.add(Randomizer.getRandomElement(personality.getFlaws()));
        pc.setFlaws(tempSet);

    }

    private static void generateAlignment(String alignment) {
        List<String> alignList = null;
        if (alignment == null)
            alignment = "any";

        alignment.toLowerCase();

        alignList = new ArrayList<>(Arrays.asList("unaligned", "lawful evil", "neutral evil", "chaotic evil", "lawful good", "neutral good", "chaotic good", "neutral", "lawful neutral", "chaotic neutral"));

        //specific alignment
        if (alignList.contains(alignment)) {
            alignment = StringUtils.capitalize(alignment);
            pc.setAlignment(alignment);
            return;
        }

        //filter alignments
        if (alignment.contains("not")) {
            List<String> acceptedList = new ArrayList<>();
            alignment = alignment.substring(4);

            for (String al : alignList) {
                if (!al.contains(alignment))
                    acceptedList.add(al);

            }

            alignment = Randomizer.getRandomElement(acceptedList);
            pc.setAlignment(alignment);
            return;
        }

        //some alignments
        switch (alignment) {
            case "any evil":
                alignList = new ArrayList<>(Arrays.asList("Lawful Evil", "Neutral Evil", "Chaotic Evil"));
                break;

            case "any good":
                alignList = new ArrayList<>(Arrays.asList("Lawful Good", "Neutral Good", "Chaotic Good"));
                break;

            case "any lawful":
                alignList = new ArrayList<>(Arrays.asList("Lawful Evil", "Lawful Neutral", "Lawful Good"));
                break;

            case "any chaotic":
                alignList = new ArrayList<>(Arrays.asList("Chaotic Good", "Chaotic Neutral", "Chaotic Evil"));
                break;

            case "any neutral":
                alignList = new ArrayList<>(Arrays.asList("Neutral Good", "Neutral", "Neutral Evil"));
                break;

            //any alignment
            default:
                List<String> juralList = new ArrayList<>(Arrays.asList("Lawful", "Neutral", "Chaotic"));
                List<String> moralList = new ArrayList<>(Arrays.asList("Good", "Neutral", "Evil"));

                alignment = Randomizer.getRandomElement(juralList) + " " + Randomizer.getRandomElement(moralList);

                if (alignment.equalsIgnoreCase("neutral neutral"))
                    alignment = "Neutral";
                pc.setAlignment(alignment);
                return;
        }

        alignment = Randomizer.getRandomElement(alignList);
        pc.setAlignment(alignment);


    }

    private static void addRacialBonuses() {
        pc.setStrength(pc.getStrength() + raceObj.getStrBonus());
        pc.setDexterity(pc.getDexterity() + raceObj.getDexBonus());
        pc.setConstitution(pc.getConstitution() + raceObj.getConBonus());
        pc.setIntelligence(pc.getIntelligence() + raceObj.getIntBonus());
        pc.setWisdom(pc.getWisdom() + raceObj.getWisBonus());
        pc.setCharisma(pc.getCharisma() + raceObj.getChaBonus());

        int abilpts = raceObj.getAbilpts();
        int p = 0;
        List<String> abilityOrder = classObj.getAbilityOrder();
        if (raceObj.getRaceName().equalsIgnoreCase("half-elf") ||
                (raceObj.getRaceName().equalsIgnoreCase("human") && raceObj.getSubrace().equalsIgnoreCase("variant"))) {

            for (String ability : abilityOrder) {
                switch (ability) {
                    case "STR":
                        pc.setStrength(pc.getStrength() + 1);
                        break;

                    case "DEX":
                        pc.setDexterity(pc.getDexterity() + 1);

                        break;
                    case "CON":
                        pc.setConstitution(pc.getConstitution() + 1);

                        break;
                    case "INT":
                        pc.setIntelligence(pc.getIntelligence() + 1);

                        break;
                    case "WIS":
                        pc.setWisdom(pc.getWisdom() + 1);

                        break;
                    case "CHA":
                        pc.setCharisma(pc.getCharisma() + 1);
                        break;

                    default:
                        break;
                }

                p++;

                if (p == abilpts)
                    break;
            }

        }


    }

    private static void generateAbilityScores() {
        List<Integer> rolls = AbilityScoreGenerator.methodStandard4d6();

        int sum = 0;

        HashMap<String, Integer> originalRolls = new HashMap<>();

        List<String> abilityOrder = classObj.getAbilityOrder();

        for (String ability : abilityOrder) {

            switch (ability) {
                case "STR":
                    pc.setStrength(rolls.get(0));
                    rolls.remove(0);
                    break;
                case "DEX":
                    pc.setDexterity(rolls.get(0));
                    rolls.remove(0);
                    break;
                case "CON":
                    pc.setConstitution(rolls.get(0));
                    rolls.remove(0);
                    break;
                case "INT":
                    pc.setIntelligence(rolls.get(0));
                    rolls.remove(0);
                    break;
                case "WIS":
                    pc.setWisdom(rolls.get(0));
                    rolls.remove(0);
                    break;
                case "CHA":
                    pc.setCharisma(rolls.get(0));
                    rolls.remove(0);
                    break;

                default:
                    break;
            }

        }

        originalRolls.put("STR", pc.getStrength());
        originalRolls.put("DEX", pc.getDexterity());
        originalRolls.put("CON", pc.getConstitution());
        originalRolls.put("INT", pc.getIntelligence());
        originalRolls.put("WIS", pc.getWisdom());
        originalRolls.put("CHA", pc.getCharisma());

        pc.setOriginalRolls(originalRolls);

    }

    private static void generateRaceData(String race, String gender, boolean isBonusFeat) {
        if (race == null)
            race = Randomizer.getRandomElement(RacesManager.getSimpleRacesList());

        List<Race> races = RacesManager.getSubracesByRace(race);
        raceObj = (Race) Randomizer.getRandomObject(races);

        if (isBonusFeat && raceObj.getRaceName().equalsIgnoreCase("human") && raceObj.getSubrace().equalsIgnoreCase("variant"))
            raceObj = RacesManager.getRaceBySubrace("human", "standard");

        System.out.println("RACE: " + raceObj.getSubrace() + " " + raceObj.getRaceName() + "\n");
        pc.setRace(raceObj.getRaceName());
        pc.setSubrace(raceObj.getSubrace());
        pc.setSpeed(raceObj.getSpeed());
        pc.setGender(gender);
        pc.setSize(raceObj.getSize());
        pc.setSpeed(raceObj.getSpeed());
        pc.setAge(raceObj.getAgeStart() + DiceRoller.roll1d6());
        pc.setLanguages(raceObj.getLanguages());
        pc.setRaceTraits(raceObj.getRacialTraits());
        pc.setResistances(raceObj.getResistances());
        pc.setImmunities(raceObj.getImmunities());
        pc.setVulnerabilities(raceObj.getVulnerabilities());
        pc.setFirstName(gender.equalsIgnoreCase("male") ? Randomizer.getRandomElement(raceObj.getMaleNames()) : Randomizer.getRandomElement(raceObj.getFemaleNames()));
        pc.setLastName(Randomizer.getRandomElement(raceObj.getClanNames()));
        calculateRaceHeightAndWeight(raceObj);
    }

    private static void generateClassData(String chClass, int level) {

        HashMap<String, HashMap<String, Integer>> levelMap = new HashMap<>();
        String archetype;

        if (classObj.getArchetypeStart() <= level) {
            archetype = getRandomArchetypeFromClass(classObj);
        } else {
            archetype = "Base";
        }

        String finalArchetype = archetype;
        levelMap.put(classObj.getClassName(), new HashMap() {{
            put(finalArchetype, level);
        }});

        List<ClassFeature> classFeatures = ClassFeaturesManager.getFeaturesByClassAndArchetype(classObj.getClassName(), finalArchetype, level);
        Set<String> features = classFeatures.stream()
                .map(ClassFeature::getFeature)
                .collect(Collectors.toSet());

        pc.setLevelMap(levelMap);
        pc.setClassFeatures(features);
        pc.setArmorProfs(classObj.getArmorProficiencies());
        pc.setWeaponProfs(classObj.getWeaponProficiencies());
        pc.setSavingThrowProfs(classObj.getSaveProficiencies());
        generateSkills();
        generateLanguages();
        generateArchetypeBonuses(classObj.getClassName(), finalArchetype, level);

    }

    private static void generateArchetypeBonuses(String clName, String archetype, int level) {
        List<ClassFeature> classFeatureList = ClassFeaturesManager.getFeaturesByClassAndArchetype(clName, archetype, level);

        for (ClassFeature clf : classFeatureList) {

            //add bonus weapon proficiencies
            Set<String> weaponProfs = pc.getWeaponProfs();
            weaponProfs.addAll(clf.getBonusWeaponProfs());
            pc.setWeaponProfs(weaponProfs);

            //add bonus armor proficiencies
            Set<String> armorProfs = pc.getArmorProfs();
            armorProfs.addAll(clf.getBonusArmorProfs());
            pc.setArmorProfs(armorProfs);

            //add tool proficincies
            Set<String> toolProfs = pc.getToolProfs();
            toolProfs.addAll(clf.getBonusToolProfs());
            pc.setToolProfs(toolProfs);

            //add bonus languages
            Set<String> languages = pc.getLanguages();
            Set<String> languageList = LanguageManager.getAllLanguagesList();
            int langs = languages.size() + clf.getNumberBonusLanguages();

            while (languages.size() < langs) {
                String lng = Randomizer.getRandomElement(languageList);
                languages.add(lng);
            }
            pc.setLanguages(languages);

            //add bonus skills
            Set<String> skillProfs = pc.getSkillProfs();
            int n = skillProfs.size() + clf.getNumberBonusSkills();
            String skill = null;

            while (skillProfs.size() < n) {
                Set<String> skills = clf.getBonusSkillChoices();
                if (pc.getSkillProfs().containsAll(skills) || skills == null)
                    skills = SkillsManager.getSkillsList();

                skill = Randomizer.getRandomElement(skills);
                skillProfs.add(skill);
            }

            pc.setSkillProfs(skillProfs);

            //add expertise skills
            Set<String> expertSkills = new HashSet<>();

            if (pc.getExpertSkills() != null)
                expertSkills = pc.getExpertSkills();

            int x = clf.getNumberExpertiseSkills();

            while (x > 0) {
                String es = Randomizer.getRandomElement(skillProfs);
                if (!expertSkills.contains(es)) {
                    expertSkills.add(es);
                    x--;
                }

            }

            pc.setExpertSkills(expertSkills);
        }
    }

    private static void generateSkills() {
        Set<String> raceSkills = raceObj.getSkills();
        Set<String> backgroundSkills = backgroundObj.getSkills();
        Set<String> skillList = SkillsManager.getSkillsList();

        int r = raceSkills.size();
        int b = backgroundSkills.size();
        int c = classObj.getNumberOfSkills();
        int totalSkills = r + b + c;

        for (String bs : backgroundSkills)
            raceSkills.add(bs);

        Set<String> skills = new HashSet<>(raceSkills);

        do {
            skills.add(Randomizer.getRandomElement(classObj.getClassSkills()));

        } while (skills.size() < totalSkills);

        if (raceObj.getRaceName().equalsIgnoreCase("half-elf")) {
            totalSkills = totalSkills + 2;
            do {
                skills.add(Randomizer.getRandomElement(skillList));

            } while (skills.size() < totalSkills);
        }

        pc.setSkillProfs(skills);
        generateTools();
    }

    private static void generateTools() {
        Set<String> tools = new HashSet<>();

        Set<String> freeRaceTools = raceObj.getFreeTools();
        Set<String> freeBackgroundTools = backgroundObj.getFreeTools();
        Set<String> freeClassTools = classObj.getFreeTools();

        int s = freeRaceTools.size() + freeBackgroundTools.size() + freeClassTools.size();

        tools.addAll(freeRaceTools);
        tools.addAll(freeBackgroundTools);
        tools.addAll(freeClassTools);


        int r = s - tools.size();

        //race tools
        if (raceObj.getToolChoices().size() > 0) {
            int i = 1;
            while (i > 0) {
                String toolChoice = Randomizer.getRandomElement(raceObj.getToolChoices());

                if (!tools.contains(toolChoice)) {
                    tools.add(toolChoice);
                    i--;
                } else {
                    continue;
                }
            }
        }


        //background tools
        if (backgroundObj.getToolChoices().size() > 0) {
            int i = 1;
            while (i > 0) {
                String toolChoice = Randomizer.getRandomElement(backgroundObj.getToolChoices());

                if (!tools.contains(toolChoice)) {
                    tools.add(toolChoice);
                    i--;
                } else {
                    continue;
                }
            }
        }

        //class tools
        if (classObj.getNumberOfTools() > 0) {
            int i = classObj.getNumberOfTools();
            while (i > 0) {
                String toolChoice = Randomizer.getRandomElement(classObj.getToolChoices());

                if (!tools.contains(toolChoice)) {
                    tools.add(toolChoice);
                    i--;
                } else {
                    continue;
                }
            }
        }

        //class tools
        if (r > 0) {
            while (r > 0) {
                String toolChoice = Randomizer.getRandomElement(getAllTools());

                if (!tools.contains(toolChoice)) {
                    tools.add(toolChoice);
                    r--;
                } else {
                    continue;
                }
            }
        }
        pc.setToolProfs(tools);

    }

    private static Set<String> getRandomToolsByClass(CharacterClass classObj) {
        Set<String> tools = new HashSet<>();

        if (classObj.getToolChoices().isEmpty())
            return null;

        do {
            tools.add(Randomizer.getRandomElement(classObj.getToolChoices()));

        } while (tools.size() < classObj.getNumberOfTools());


        return tools;
    }

    private static String getRandomArchetypeFromClass(CharacterClass chClass) {
        return Randomizer.getRandomElement(chClass.getArchetypes());

    }


    private static void calculateRaceHeightAndWeight(Race raceObj) {
        int mod = DiceRoller.randInt(raceObj.getHeightModLow(), raceObj.getHeightModHigh(), 0);
        int ht = raceObj.getBaseHeight() + mod;
        int wt = raceObj.getBaseWeight() + (mod * DiceRoller.randInt(raceObj.getWeightModLow(), raceObj.getWeightModHigh(), 0));

        pc.setHeight(ht);
        pc.setWeight(wt);

    }

    private static Set<String> getAllTools() {
        Set<String> toolList = Stream.of("Bagpipes", "Drum", "Dulcimer", "Flute", "Horn", "Lute", "Lyre", "Pan Flute", "Shawm", "Viol",
                "Alchemist's Supplies", "Brewer's Supplies", "Calligrapher's Supplies", "Carpenter's Tools", "Cartographer's Tools",
                "Cobbler's Tools", "Cook's Utensils", "Glassblower's Tools", "Jeweler's Tools", "Leatherworker's Tools", "Mason's Tools",
                "Painter's Supplies", "Potter's Tools", "Smith's Tools", "Tinker's Tools", "Weaver's Tools", "Woodcarver's Tools").collect(Collectors.toSet());

        return toolList;
    }

}

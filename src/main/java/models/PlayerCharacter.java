package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerCharacter {

    @JsonProperty("PCID")
    private String pcid;
    @JsonProperty("USERID")
    private String userId;
    @JsonProperty("ABILITYLIMITS")
    private boolean abilityLimits;
    @JsonProperty("PLAYERNAME")
    private String playerName;
    @JsonProperty("CREATIONDATE")
    private Date creationDate;
    @JsonProperty("FIRSTNAME")
    private String firstName;
    @JsonProperty("LASTNAME")
    private String lastName;
    @JsonProperty("RACE")
    private String race;
    @JsonProperty("SUBRACE")
    private String subrace;
    @JsonProperty("ALIGNMENT")
    private String alignment;
    @JsonProperty("CAMPAIGNWORLD")
    private String campaignWorld;
    @JsonProperty("DEITY")
    private String deity;
    @JsonProperty("GENDER")
    private String gender;
    @JsonProperty("AGE")
    private int age;
    @JsonProperty("HEIGHT")
    private int height;
    @JsonProperty("WEIGHT")
    private int weight;
    @JsonProperty("SIZE")
    private String size;
    @JsonProperty("APPEARANCEDESCRIPTION")
    private String appearanceDescription;
    @JsonProperty("BACKGROUND")
    private String background;
    @JsonProperty("TRAITS")
    private Set<String> traits;
    @JsonProperty("IDEALS")
    private Set<String> ideals;
    @JsonProperty("BONDS")
    private Set<String> bonds;
    @JsonProperty("FLAWS")
    private Set<String> flaws;
    @JsonProperty("STRENGTH")
    private int strength;
    @JsonProperty("DEXTERITY")
    private int dexterity;
    @JsonProperty("CONSTITUTION")
    private int constitution;
    @JsonProperty("INTELLIGENCE")
    private int intelligence;
    @JsonProperty("WISDOM")
    private int wisdom;
    @JsonProperty("CHARISMA")
    private int charisma;
    @JsonProperty("STRENGTHSAVE")
    private int strengthSave;
    @JsonProperty("DEXTERITYSAVE")
    private int dexteritySave;
    @JsonProperty("CONSTITUTIONSAVE")
    private int constitutionSave;
    @JsonProperty("INTELLIGENCESAVE")
    private int intelligenceSave;
    @JsonProperty("WISDOMSAVE")
    private int wisdomSave;
    @JsonProperty("CHARISMASAVE")
    private int charismaSave;
    @JsonProperty("ORIGINALROLLS")
    //original assigned ability scores
    private HashMap<String, Integer> originalRolls;
    @JsonProperty("LEVELMAP")
    //Class, Archetype, Level
    private Map<String, HashMap<String, Integer>> levelMap;
    @JsonProperty("CLASSFEATURES")
    private Set<String> classFeatures;
    @JsonProperty("ISMULTICLASS")
    private boolean isMulticlass;
    @JsonProperty("HITDICE")
    private List<String> hitDice;
    @JsonProperty("MAXHITPOINTS")
    private int maxHitPoints;
    @JsonProperty("CURRENTHITPOINTS")
    private int currentHitPoints;
    @JsonProperty("TEMPHITPOINTS")
    private int tempHitPoints;
    @JsonProperty("INSPIRATION")
    private int inspiration;
    @JsonProperty("SAVINGTHROWPROFS")
    private Set<String> savingThrowProfs;
    @JsonProperty("SKILLPROFS")
    private Set<String> skillProfs;
    @JsonProperty("EXPERTSKILLS")
    private Set<String> expertSkills;
    @JsonProperty("WEAPONPROFS")
    private Set<String> weaponProfs;
    @JsonProperty("ARMORPROFS")
    private Set<String> armorProfs;
    @JsonProperty("TOOLPROFS")
    private Set<String> toolProfs;
    @JsonProperty("LANGUAGES")
    private Set<String> languages;
    @JsonProperty("FIGHTINGSTYLES")
    private Set<String> fightingStyles;
    @JsonProperty("MAXRAGES")
    private int maxRages;
    @JsonProperty("CURRENTRAGES")
    private int currentRages;
    @JsonProperty("TOTEMSPIRITS")
    private Set<String> totemSpirits;
    @JsonProperty("DRUIDICCIRCLE")
    private String druidicCircle;
    @JsonProperty("BATTLEMANEUVERS")
    private Set<String> battleManeuvers;
    @JsonProperty("CRITICALHIT")
    private int criticalHit;
    @JsonProperty("MAXKIPOINTS")
    private int maxKiPoints;
    @JsonProperty("CURRENTKIPOINTS")
    private int currentKiPoints;
    @JsonProperty("MAXSORCERYPOINTS")
    private int maxSorceryPoints;
    @JsonProperty("CURRENTSORCERYPOINTS")
    private int currentSorceryPoints;
    @JsonProperty("ELEMENTALDISCIPLINES")
    private Set<String> elementalDisciplines;
    @JsonProperty("FAVOREDENEMIES")
    private Set<String> favoredEnemies;
    @JsonProperty("HUNTERFEATURES")
    private Set<String> hunterFeatures;
    @JsonProperty("ELDRITCHINVOCATIONS")
    private Set<String> eldritchInvocations;
    @JsonProperty("SNEAKATTACKDAMAGE")
    private String sneakAttackDamage;
    @JsonProperty("METAMAGICOPTIONS")
    private Set<String> metamagicOptions;
    @JsonProperty("DRAGONANCESTOR")
    private String dragonAncestor;
    @JsonProperty("ARMOREQUIPPED")
    private String armorEquipped;
    @JsonProperty("SHIELDEQUIPPED")
    private String shieldEquipped;
    @JsonProperty("TAKEBONUSFEAT")
    private boolean takeBonusFeat;
    @JsonProperty("FEATS")
    private Set<String> feats;
    @JsonProperty("RACETRAITS")
    private Set<String> raceTraits;
    @JsonProperty("RESISTANCES")
    private Set<String> resistances;
    @JsonProperty("VULNERABILITIES")
    private Set<String> vulnerabilities;
    @JsonProperty("IMMUNITIES")
    private Set<String> immunities;
    @JsonProperty("CURRENTCONDITIONS")
    private Set<String> currentConditions;
    @JsonProperty("EXHAUSTIONLEVEL")
    private int exhaustionLevel;
    //item name, quantity
    @JsonProperty("INVENTORY")
    private Map<String, Integer> inventory;

    @JsonProperty("SPELLBOOKID")
    private String spellbookID;

    //*****CALCULATED FIELDS*****

    // Dex bonus (+5 with Alert Feat)
    @JsonProperty("INITIATIVE")
    private int initiative;
    //armor + maxDex bonus + magic bonus
    @JsonProperty("ARMORCLASS")
    private int armorClass;
    @JsonProperty("UNARMOREDARMORCLASS")
    private int UnarmoredArmorClass;
    @JsonProperty("SKILLCHECKBONUSES")
    private Map<String, Integer> skillCheckBonuses;
    @JsonProperty("PASSIVESKILLS")
    private Map<String, Integer> passiveSkills;
    @JsonProperty("NUMBEROFATTACKS")
    private int numberOfAttacks;
    @JsonProperty("MELEEATTACKBONUS")
    private int meleeAttackBonus;
    @JsonProperty("RANGEDATTACKBONUS")
    private int rangedAttackBonus;
    @JsonProperty("UNARMEDATTACKBONUS")
    private int unarmedAttackBonus;
    @JsonProperty("SPELLDC")
    private int spellDC;
    @JsonProperty("TOTALLEVEL")
    private int totalLevel;
    @JsonProperty("PROFICIENCYBONUS")
    private int proficiencyBonus;
    @JsonProperty("SPEED")
    private int speed;
    @JsonProperty("SKILLABILITYMAP")
    private Map<String, String> skillAbilityMap = new HashMap<>() {{
        put("Athletics", "strength");
        put("Acrobatics", "dexterity");
        put("Sleight of Hand", "dexterity");
        put("Stealth", "dexterity");
        put("Arcana", "intelligence");
        put("History", "intelligence");
        put("Investigation", "intelligence");
        put("Nature", "intelligence");
        put("Religion", "intelligence");
        put("Animal Handling", "wisdom");
        put("Insight", "wisdom");
        put("Medicine", "wisdom");
        put("Perception", "wisdom");
        put("Survival", "wisdom");
        put("Deception", "charisma");
        put("Intimidation", "charisma");
        put("Performance", "charisma");
        put("Persuasion", "charisma");
    }};

    @JsonProperty("ABILITYMODIFIERSMAP")
    private Map<String, Integer> abilityModifiersMap = new HashMap<>();

    @JsonIgnore
    public Map<String, Integer> getAbilityModifiersMap() {
        return abilityModifiersMap;
    }

    public void setAbilityModifiersMap(Map<String, Integer> abilityModifiersMap) {
        this.abilityModifiersMap = abilityModifiersMap;
    }

    @JsonIgnore
    public int getMeleeAttackBonus() {
        return meleeAttackBonus;
    }

    public void setMeleeAttackBonus(int meleeAttackBonus) {
        this.meleeAttackBonus = meleeAttackBonus;
    }

    @JsonIgnore
    public int getRangedAttackBonus() {
        return rangedAttackBonus;
    }

    public void setRangedAttackBonus(int rangedAttackBonus) {
        this.rangedAttackBonus = rangedAttackBonus;
    }

    @JsonIgnore
    public int getUnarmedAttackBonus() {
        return unarmedAttackBonus;
    }

    public void setUnarmedAttackBonus(int unarmedAttackBONUS) {
        this.unarmedAttackBonus = unarmedAttackBONUS;
    }

    @JsonIgnore
    public int getStrengthSave() {
        return strengthSave;
    }

    public void setStrengthSave(int strengthSave) {
        this.strengthSave = strengthSave;
    }

    @JsonIgnore
    public int getDexteritySave() {
        return dexteritySave;
    }

    public void setDexteritySave(int dexteritySave) {
        this.dexteritySave = dexteritySave;
    }

    @JsonIgnore
    public int getConstitutionSave() {
        return constitutionSave;
    }

    public void setConstitutionSave(int constitutionSave) {
        this.constitutionSave = constitutionSave;
    }

    @JsonIgnore
    public int getIntelligenceSave() {
        return intelligenceSave;
    }

    public void setIntelligenceSave(int intelligenceSave) {
        this.intelligenceSave = intelligenceSave;
    }

    @JsonIgnore
    public int getWisdomSave() {
        return wisdomSave;
    }

    public void setWisdomSave(int wisdomSave) {
        this.wisdomSave = wisdomSave;
    }

    @JsonIgnore
    public int getCharismaSave() {
        return charismaSave;
    }

    public void setCharismaSave(int charismaSave) {
        this.charismaSave = charismaSave;
    }

    @JsonIgnore
    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    @JsonIgnore
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public boolean isAbilityLimits() {
        return abilityLimits;
    }

    public void setAbilityLimits(boolean abilityLimits) {
        this.abilityLimits = abilityLimits;
    }

    @JsonIgnore
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @JsonIgnore
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @JsonIgnore
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonIgnore
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @JsonIgnore
    public String getCampaignWorld() {
        return campaignWorld;
    }

    public void setCampaignWorld(String campaignWorld) {
        this.campaignWorld = campaignWorld;
    }

    @JsonIgnore
    public String getDeity() {
        return deity;
    }

    public void setDeity(String deity) {
        this.deity = deity;
    }

    @JsonIgnore
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonIgnore
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonIgnore
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @JsonIgnore
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @JsonIgnore
    public String getAppearanceDescription() {
        return appearanceDescription;
    }

    public void setAppearanceDescription(String appearanceDescription) {
        this.appearanceDescription = appearanceDescription;
    }

    @JsonIgnore
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @JsonIgnore
    public Set<String> getTraits() {
        return traits;
    }

    public void setTraits(Set<String> traits) {
        this.traits = traits;
    }

    @JsonIgnore
    public Set<String> getIdeals() {
        return ideals;
    }

    public void setIdeals(Set<String> ideals) {
        this.ideals = ideals;
    }

    @JsonIgnore
    public Set<String> getBonds() {
        return bonds;
    }

    public void setBonds(Set<String> bonds) {
        this.bonds = bonds;
    }

    @JsonIgnore
    public Set<String> getFlaws() {
        return flaws;
    }

    public void setFlaws(Set<String> flaws) {
        this.flaws = flaws;
    }

    @JsonIgnore
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @JsonIgnore
    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @JsonIgnore
    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    @JsonIgnore
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @JsonIgnore
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    @JsonIgnore
    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @JsonIgnore
    public HashMap<String, Integer> getOriginalRolls() {
        return originalRolls;
    }

    public void setOriginalRolls(HashMap<String, Integer> originalRolls) {
        this.originalRolls = originalRolls;
    }

    @JsonIgnore
    public Map<String, HashMap<String, Integer>> getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(Map<String, HashMap<String, Integer>> levelMap) {
        this.levelMap = levelMap;
    }

    @JsonIgnore
    public Set<String> getClassFeatures() {
        return classFeatures;
    }

    public void setClassFeatures(Set<String> classFeatures) {
        this.classFeatures = classFeatures;
    }

    @JsonIgnore
    public boolean isMulticlass() {
        return isMulticlass;
    }

    public void setMulticlass(boolean multiclass) {
        isMulticlass = multiclass;
    }

    @JsonIgnore
    public List<String> getHitDice() {
        return hitDice;
    }

    public void setHitDice(List<String> hitDice) {
        this.hitDice = hitDice;
    }


    @JsonIgnore
    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    @JsonIgnore
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    @JsonIgnore
    public int getTempHitPoints() {
        return tempHitPoints;
    }

    public void setTempHitPoints(int tempHitPoints) {
        this.tempHitPoints = tempHitPoints;
    }

    @JsonIgnore
    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    @JsonIgnore
    public Set<String> getSavingThrowProfs() {
        return savingThrowProfs;
    }

    public void setSavingThrowProfs(Set<String> savingThrowProfs) {
        this.savingThrowProfs = savingThrowProfs;
    }

    @JsonIgnore
    public Set<String> getSkillProfs() {
        return skillProfs;
    }

    public void setSkillProfs(Set<String> skillProfs) {
        this.skillProfs = skillProfs;
    }

    @JsonIgnore
    public Set<String> getExpertSkills() {
        return expertSkills;
    }

    public void setExpertSkills(Set<String> expertSkills) {
        this.expertSkills = expertSkills;
    }

    @JsonIgnore
    public Set<String> getWeaponProfs() {
        return weaponProfs;
    }

    public void setWeaponProfs(Set<String> weaponProfs) {
        this.weaponProfs = weaponProfs;
    }

    @JsonIgnore
    public Set<String> getArmorProfs() {
        return armorProfs;
    }

    public void setArmorProfs(Set<String> armorProfs) {
        this.armorProfs = armorProfs;
    }

    @JsonIgnore
    public Set<String> getToolProfs() {
        return toolProfs;
    }

    public void setToolProfs(Set<String> toolProfs) {
        this.toolProfs = toolProfs;
    }

    @JsonIgnore
    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    @JsonIgnore
    public Set<String> getFightingStyles() {
        return fightingStyles;
    }

    public void setFightingStyles(Set<String> fightingStyles) {
        this.fightingStyles = fightingStyles;
    }

    @JsonIgnore
    public int getMaxRages() {
        return maxRages;
    }

    public void setMaxRages(int maxRages) {
        this.maxRages = maxRages;
    }

    @JsonIgnore
    public int getCurrentRages() {
        return currentRages;
    }

    public void setCurrentRages(int currentRages) {
        this.currentRages = currentRages;
    }

    @JsonIgnore
    public Set<String> getTotemSpirits() {
        return totemSpirits;
    }

    public void setTotemSpirits(Set<String> totemSpirits) {
        this.totemSpirits = totemSpirits;
    }

    @JsonIgnore
    public String getDruidicCircle() {
        return druidicCircle;
    }

    public void setDruidicCircle(String druidicCircle) {
        this.druidicCircle = druidicCircle;
    }

    @JsonIgnore
    public Set<String> getBattleManeuvers() {
        return battleManeuvers;
    }

    public void setBattleManeuvers(Set<String> battleManeuvers) {
        this.battleManeuvers = battleManeuvers;
    }

    @JsonIgnore
    public int getCriticalHit() {
        return criticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        this.criticalHit = criticalHit;
    }

    @JsonIgnore
    public int getMaxKiPoints() {
        return maxKiPoints;
    }

    public void setMaxKiPoints(int maxKiPoints) {
        this.maxKiPoints = maxKiPoints;
    }

    @JsonIgnore
    public int getCurrentKiPoints() {
        return currentKiPoints;
    }

    public void setCurrentKiPoints(int currentKiPoints) {
        this.currentKiPoints = currentKiPoints;
    }

    @JsonIgnore
    public int getMaxSorceryPoints() {
        return maxSorceryPoints;
    }

    public void setMaxSorceryPoints(int maxSorceryPoints) {
        this.maxSorceryPoints = maxSorceryPoints;
    }

    @JsonIgnore
    public int getCurrentSorceryPoints() {
        return currentSorceryPoints;
    }

    public void setCurrentSorceryPoints(int currentSorceryPoints) {
        this.currentSorceryPoints = currentSorceryPoints;
    }

    @JsonIgnore
    public Set<String> getElementalDisciplines() {
        return elementalDisciplines;
    }

    public void setElementalDisciplines(Set<String> elementalDisciplines) {
        this.elementalDisciplines = elementalDisciplines;
    }

    @JsonIgnore
    public Set<String> getFavoredEnemies() {
        return favoredEnemies;
    }

    public void setFavoredEnemies(Set<String> favoredEnemies) {
        this.favoredEnemies = favoredEnemies;
    }

    @JsonIgnore
    public Set<String> getHunterFeatures() {
        return hunterFeatures;
    }

    public void setHunterFeatures(Set<String> hunterFeatures) {
        this.hunterFeatures = hunterFeatures;
    }

    @JsonIgnore
    public String getSneakAttackDamage() {
        return sneakAttackDamage;
    }

    public void setSneakAttackDamage(String sneakAttackDamage) {
        this.sneakAttackDamage = sneakAttackDamage;
    }

    @JsonIgnore
    public Set<String> getMetamagicOptions() {
        return metamagicOptions;
    }

    public void setMetamagicOptions(Set<String> metamagicOptions) {
        this.metamagicOptions = metamagicOptions;
    }

    @JsonIgnore
    public String getDragonAncestor() {
        return dragonAncestor;
    }

    public void setDragonAncestor(String dragonAncestor) {
        this.dragonAncestor = dragonAncestor;
    }

    @JsonIgnore
    public String getArmorEquipped() {
        return armorEquipped;
    }

    public void setArmorEquipped(String armorEquipped) {
        this.armorEquipped = armorEquipped;
    }

    @JsonIgnore
    public String getShieldEquipped() {
        return shieldEquipped;
    }

    public void setShieldEquipped(String shieldEquipped) {
        this.shieldEquipped = shieldEquipped;
    }

    @JsonIgnore
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @JsonIgnore
    public String getSubrace() {
        return subrace;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    @JsonIgnore
    public Set<String> getFeats() {
        return feats;
    }

    public void setFeats(Set<String> feats) {
        this.feats = feats;
    }

    @JsonIgnore
    public Set<String> getRaceTraits() {
        return raceTraits;
    }

    public void setRaceTraits(Set<String> raceTraits) {
        this.raceTraits = raceTraits;
    }

    @JsonIgnore
    public Set<String> getResistances() {
        return resistances;
    }

    public void setResistances(Set<String> resistances) {
        this.resistances = resistances;
    }

    @JsonIgnore
    public Set<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    @JsonIgnore
    public Set<String> getImmunities() {
        return immunities;
    }

    public void setImmunities(Set<String> immunities) {
        this.immunities = immunities;
    }

    @JsonIgnore
    public Set<String> getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(Set<String> currentConditions) {
        this.currentConditions = currentConditions;
    }

    @JsonIgnore
    public int getExhaustionLevel() {
        return exhaustionLevel;
    }

    public void setExhaustionLevel(int exhaustionLevel) {
        this.exhaustionLevel = exhaustionLevel;
    }

    @JsonIgnore
    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    @JsonIgnore
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @JsonIgnore
    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getUnarmoredArmorClass() {
        return UnarmoredArmorClass;
    }

    public void setUnarmoredArmorClass(int unarmoredArmorClass) {
        UnarmoredArmorClass = unarmoredArmorClass;
    }

    @JsonIgnore
    public Map<String, Integer> getSkillCheckBonuses() {
        return skillCheckBonuses;
    }

    public void setSkillCheckBonuses(Map<String, Integer> skillCheckBonuses) {
        this.skillCheckBonuses = skillCheckBonuses;
    }

    @JsonIgnore
    public Map<String, Integer> getPassiveSkills() {
        return passiveSkills;
    }

    public void setPassiveSkills(Map<String, Integer> passiveSkills) {
        this.passiveSkills = passiveSkills;
    }


    @JsonIgnore
    public int getNumberOfAttacks() {
        return numberOfAttacks;
    }

    public void setNumberOfAttacks(int numberOfAttacks) {
        this.numberOfAttacks = numberOfAttacks;
    }

    @JsonIgnore
    public int getSpellDC() {
        return spellDC;
    }

    public void setSpellDC(int spellDC) {
        this.spellDC = spellDC;
    }

    @JsonIgnore
    public int getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(int totalLevel) {
        this.totalLevel = totalLevel;
    }

    @JsonIgnore
    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    @JsonIgnore
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @JsonIgnore
    public boolean isTakeBonusFeat() {
        return takeBonusFeat;
    }

    public void setTakeBonusFeat(boolean takeBonusFeat) {
        this.takeBonusFeat = takeBonusFeat;
    }

    @JsonIgnore
    public Map<String, String> getSkillAbilityMap() {
        return skillAbilityMap;
    }

    public void setSkillAbilityMap(Map<String, String> skillAbilityMap) {
        this.skillAbilityMap = skillAbilityMap;
    }

    @JsonIgnore
    public String getSpellbookID() {
        return spellbookID;
    }

    public void setSpellbookID(String spellbookID) {
        this.spellbookID = spellbookID;
    }

    @JsonIgnore
    public Set<String> getEldritchInvocations() {
        return eldritchInvocations;
    }

    public void setEldritchInvocations(Set<String> eldritchInvocations) {
        this.eldritchInvocations = eldritchInvocations;
    }
}

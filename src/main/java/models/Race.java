package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class Race {

    @JsonProperty("RACEID")
    private String raceID;
    @JsonProperty("RACENAME")
    private String raceName;
    @JsonProperty("SUBRACE")
    private String subrace;
    @JsonProperty("BONUSLANG")
    private int bonuslang;
    @JsonProperty("BONUSSKILLS")
    private int bonusSkills;
    @JsonProperty("LANGUAGES")
    private Set<String> languages;
    @JsonProperty("ARMORPROFS")
    private Set<String> armorProfs;
    @JsonProperty("WEAPONPROFS")
    private Set<String> weaponProfs;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("STRBONUS")
    @JsonAlias("STRINC")
    private int strBonus;
    @JsonProperty("DEXBONUS")
    @JsonAlias("DEXINC")
    private int dexBonus;
    @JsonProperty("CONBONUS")
    @JsonAlias("CONINC")
    private int conBonus;
    @JsonProperty("INTBONUS")
    @JsonAlias("INTINC")
    private int intBonus;
    @JsonProperty("WISBONUS")
    @JsonAlias("WISINC")
    private int wisBonus;
    @JsonProperty("CHABONUS")
    @JsonAlias("CHAINC")
    private int chaBonus;
    @JsonProperty("ABILPTS")
    private int abilpts;
    @JsonProperty("AGESTART")
    private int ageStart;
    @JsonProperty("LIFESPAN")
    private int lifespan;
    @JsonProperty("ALIGNMENT")
    private String alignment;
    @JsonProperty("SIZE")
    private String size;
    @JsonProperty("SPEED")
    private int speed;
    @JsonProperty("RACIALTRAITS")
    @JsonAlias("TRAITS")
    private Set<String> racialTraits;
    @JsonProperty("CANTRIPS")
    private Set<String> cantrips;
    @JsonProperty("BONUSFEATS")
    private int bonusFeats;
    @JsonProperty("SKILLS")
    private Set<String> skills;
    @JsonProperty("FREETOOLS")
    private Set<String> freeTools;
    @JsonProperty("TOOLCHOICES")
    private Set<String> toolChoices;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("BASEHEIGHT")
    private int baseHeight;
    @JsonProperty("HEIGHTMODLOW")
    private int heightModLow;
    @JsonProperty("HEIGHTMODHIGH")
    private int HeightModHigh;
    @JsonProperty("BASEWEIGHT")
    private int baseWeight;
    @JsonProperty("WEIGHTMODLOW")
    private int weightModLow;
    @JsonProperty("WEIGHTMODHIGH")
    private int weightModHigh;
    @JsonProperty("RESISTANCES")
    private Set<String> resistances;
    @JsonProperty("IMMUNITIES")
    private Set<String> immunities;
    @JsonProperty("VULNERABILITIES")
    private Set<String> vulnerabilities;
    @JsonProperty("MALENAMES")
    private List<String> maleNames;
    @JsonProperty("FEMALENAMES")
    private List<String> femaleNames;
    @JsonProperty("SPECIALNAMES")
    private List<String> specialNames;
    @JsonProperty("SPECIALMONIKER")
    private String specialMoniker;
    @JsonProperty("CLANNAMES")
    private List<String> clanNames;

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public int getBonusSkills() {
        return bonusSkills;
    }

    public void setBonusSkills(int bonusSkills) {
        this.bonusSkills = bonusSkills;
    }

    @JsonIgnore
    public Set<String> getArmorProfs() {
        return armorProfs;
    }

    public void setArmorProfs(Set<String> armorProfs) {
        this.armorProfs = armorProfs;
    }

    @JsonIgnore
    public Set<String> getWeaponProfs() {
        return weaponProfs;
    }

    public void setWeaponProfs(Set<String> weaponProfs) {
        this.weaponProfs = weaponProfs;
    }

    @JsonIgnore
    public Set<String> getCantrips() {
        return cantrips;
    }

    public void setCantrips(Set<String> cantrips) {
        this.cantrips = cantrips;
    }

    @JsonIgnore
    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    @JsonIgnore
    public Set<String> getFreeTools() {
        return freeTools;
    }

    public void setFreeTools(Set<String> freeTools) {
        this.freeTools = freeTools;
    }

    @JsonIgnore
    public Set<String> getToolChoices() {
        return toolChoices;
    }

    public void setToolChoices(Set<String> toolChoices) {
        this.toolChoices = toolChoices;
    }

    @JsonIgnore
    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @JsonIgnore
    public String getSubrace() {
        return subrace;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    @JsonIgnore
    public int getBonuslang() {
        return bonuslang;
    }

    public void setBonuslang(int bonuslang) {
        this.bonuslang = bonuslang;
    }

    @JsonIgnore
    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public int getStrBonus() {
        return strBonus;
    }

    public void setStrBonus(int strBonus) {
        this.strBonus = strBonus;
    }

    @JsonIgnore
    public int getDexBonus() {
        return dexBonus;
    }

    public void setDexBonus(int dexBonus) {
        this.dexBonus = dexBonus;
    }

    @JsonIgnore
    public int getConBonus() {
        return conBonus;
    }

    public void setConBonus(int conBonus) {
        this.conBonus = conBonus;
    }

    @JsonIgnore
    public int getIntBonus() {
        return intBonus;
    }

    public void setIntBonus(int intBonus) {
        this.intBonus = intBonus;
    }

    @JsonIgnore
    public int getWisBonus() {
        return wisBonus;
    }

    public void setWisBonus(int wisBonus) {
        this.wisBonus = wisBonus;
    }

    @JsonIgnore
    public int getChaBonus() {
        return chaBonus;
    }

    public void setChaBonus(int chaBonus) {
        this.chaBonus = chaBonus;
    }

    @JsonIgnore
    public int getAbilpts() {
        return abilpts;
    }

    public void setAbilpts(int abilpts) {
        this.abilpts = abilpts;
    }

    @JsonIgnore
    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    @JsonIgnore
    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    @JsonIgnore
    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @JsonIgnore
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @JsonIgnore
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @JsonIgnore
    public Set<String> getRacialTraits() {
        return racialTraits;
    }

    public void setRacialTraits(Set<String> racialTraits) {
        this.racialTraits = racialTraits;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public int getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(int baseHeight) {
        this.baseHeight = baseHeight;
    }

    @JsonIgnore
    public int getHeightModLow() {
        return heightModLow;
    }

    public void setHeightModLow(int heightModLow) {
        this.heightModLow = heightModLow;
    }

    @JsonIgnore
    public int getHeightModHigh() {
        return HeightModHigh;
    }

    public void setHeightModHigh(int heightModHigh) {
        HeightModHigh = heightModHigh;
    }

    @JsonIgnore
    public int getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(int baseWeight) {
        this.baseWeight = baseWeight;
    }

    @JsonIgnore
    public int getWeightModLow() {
        return weightModLow;
    }

    public void setWeightModLow(int weightModLow) {
        this.weightModLow = weightModLow;
    }

    @JsonIgnore
    public int getWeightModHigh() {
        return weightModHigh;
    }

    public void setWeightModHigh(int weightModHigh) {
        this.weightModHigh = weightModHigh;
    }

    @JsonIgnore
    public Set<String> getResistances() {
        return resistances;
    }

    public void setResistances(Set<String> resistances) {
        this.resistances = resistances;
    }

    @JsonIgnore
    public List<String> getMaleNames() {
        return maleNames;
    }

    public void setMaleNames(List<String> maleNames) {
        this.maleNames = maleNames;
    }

    @JsonIgnore
    public List<String> getFemaleNames() {
        return femaleNames;
    }

    public void setFemaleNames(List<String> femaleNames) {
        this.femaleNames = femaleNames;
    }

    @JsonIgnore
    public List<String> getSpecialNames() {
        return specialNames;
    }

    public void setSpecialNames(List<String> specialNames) {
        this.specialNames = specialNames;
    }

    @JsonIgnore
    public String getSpecialMoniker() {
        return specialMoniker;
    }

    public void setSpecialMoniker(String specialMoniker) {
        this.specialMoniker = specialMoniker;
    }

    @JsonIgnore
    public List<String> getClanNames() {
        return clanNames;
    }

    public void setClanNames(List<String> clanNames) {
        this.clanNames = clanNames;
    }

    @JsonIgnore
    public Set<String> getImmunities() {
        return immunities;
    }

    public void setImmunities(Set<String> immunities) {
        this.immunities = immunities;
    }

    @JsonIgnore
    public Set<String> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<String> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    @JsonIgnore
    public int getBonusFeats() {
        return bonusFeats;
    }

    public void setBonusFeats(int bonusFeats) {
        this.bonusFeats = bonusFeats;
    }

    @JsonIgnore
    public String getRaceID() {
        return raceID;
    }

    public void setRaceID(String raceID) {
        this.raceID = raceID;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class ClassFeature {
    @JsonProperty("FEATUREID")
    private String featureID;
    @JsonProperty("FEATURE")
    private String feature;
    @JsonProperty("ARCHETYPE")
    private String archetype;
    @JsonProperty("CLASSNAME")
    @JsonAlias("CLASS")
    private String className;
    @JsonProperty("BONUSLANGUAGES")
    private Set<String> bonusLanguages;
    @JsonProperty("BONUSWEAPONPROFS")
    private Set<String> bonusWeaponProfs;
    @JsonProperty("BONUSTOOLPROFS")
    private Set<String> bonusToolProfs;
    @JsonProperty("BONUSARMORPROFS")
    private Set<String> bonusArmorProfs;
    @JsonProperty("BONUSCANTRIPS")
    private int bonusCantrips;
    @JsonProperty("BONUSCANTRIPCHOICES")
    private Set<String> bonusCantripChoices;
    @JsonProperty("BONUSSKILLCHOICES")
    private Set<String> bonusSkillChoices;
    @JsonProperty("NUMBERBONUSSKILLS")
    private int numberBonusSkills;
    @JsonProperty("EXPERTISESKILLS")
    private int numberExpertiseSkills;
    @JsonProperty("NUMBERBONUSLANGUAGES")
    private int numberBonusLanguages;
    @JsonProperty("LEVEL")
    private int level;
    @JsonProperty("SHORTDESC")
    private String shortdesc;
    @JsonProperty("LONGDESC")
    private String longdesc;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;

    @JsonIgnore
    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @JsonIgnore
    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    @JsonIgnore
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @JsonIgnore
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @JsonIgnore
    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    @JsonIgnore
    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public Set<String> getBonusWeaponProfs() {
        return bonusWeaponProfs;
    }

    public void setBonusWeaponProfs(Set<String> bonusWeaponProfs) {
        this.bonusWeaponProfs = bonusWeaponProfs;
    }

    @JsonIgnore
    public Set<String> getBonusToolProfs() {
        return bonusToolProfs;
    }

    public void setBonusToolProfs(Set<String> bonusToolProfs) {
        this.bonusToolProfs = bonusToolProfs;
    }

    @JsonIgnore
    public Set<String> getBonusArmorProfs() {
        return bonusArmorProfs;
    }

    public void setBonusArmorProfs(Set<String> bonusArmorProfs) {
        this.bonusArmorProfs = bonusArmorProfs;
    }

    @JsonIgnore
    public int getBonusCantrips() {
        return bonusCantrips;
    }

    public void setBonusCantrips(int bonusCantrips) {
        this.bonusCantrips = bonusCantrips;
    }

    @JsonIgnore
    public Set<String> getBonusCantripChoices() {
        return bonusCantripChoices;
    }

    public void setBonusCantripChoices(Set<String> bonusCantripChoices) {
        this.bonusCantripChoices = bonusCantripChoices;
    }

    @JsonIgnore
    public Set<String> getBonusSkillChoices() {
        return bonusSkillChoices;
    }

    public void setBonusSkillChoices(Set<String> bonusSkillChoices) {
        this.bonusSkillChoices = bonusSkillChoices;
    }

    @JsonIgnore
    public int getNumberBonusSkills() {
        return numberBonusSkills;
    }

    public void setNumberBonusSkills(int numberBonusSkills) {
        this.numberBonusSkills = numberBonusSkills;
    }

    @JsonIgnore
    public int getNumberBonusLanguages() {
        return numberBonusLanguages;
    }

    public void setNumberBonusLanguages(int numberBonusLanguages) {
        this.numberBonusLanguages = numberBonusLanguages;
    }

    @JsonIgnore
    public int getNumberExpertiseSkills() {
        return numberExpertiseSkills;
    }

    public void setNumberExpertiseSkills(int numberExpertiseSkills) {
        this.numberExpertiseSkills = numberExpertiseSkills;
    }

    @JsonIgnore
    public Set<String> getBonusLanguages() {
        return bonusLanguages;
    }

    public void setBonusLanguages(Set<String> bonusLanguages) {
        this.bonusLanguages = bonusLanguages;
    }

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public String getFeatureID() {
        return featureID;
    }

    public void setFeatureID(String featureID) {
        this.featureID = featureID;
    }
}

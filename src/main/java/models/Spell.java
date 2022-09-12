package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class Spell {
    @JsonProperty("SPELLID")
    private String spellID;
    @JsonProperty("SPELLNAME")
    private String spellName;
    @JsonProperty("SPELLLEVEL")
    @JsonAlias("LEVEL")
    private int spellLevel;
    @JsonProperty("SCHOOL")
    private String school;
    @JsonProperty("RITUAL")
    private boolean ritual;
    @JsonProperty("CASTINGTIME")
    private String castingTime;
    @JsonProperty("COMPONENTS")
    private List<String> components;
    @JsonProperty("CONCENTRATE")
    private boolean concentrate;
    @JsonProperty("DURATION")
    private String duration;
    @JsonProperty("RANGE")
    private String range;
    @JsonProperty("SAVINGTHROW")
    private String savingThrow;
    @JsonProperty("HIGHERLEVELS")
    private String higherLevels;
    @JsonProperty("TARGET")
    private String target;
    @JsonProperty("ATTACKROLLS")
    private boolean attackRolls;
    @JsonProperty("SHORTDESC")
    private String shortDesc;
    @JsonProperty("FULLDESC")
    private String fullDesc;
    @JsonProperty("SPELLCASTERS")
    private Set<String> spellcasters;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    @JsonIgnore
    public int getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    @JsonIgnore
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @JsonIgnore
    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    @JsonIgnore
    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    @JsonIgnore
    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    @JsonIgnore
    public boolean isConcentrate() {
        return concentrate;
    }

    public void setConcentrate(boolean concentrate) {
        this.concentrate = concentrate;
    }

    @JsonIgnore
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonIgnore
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @JsonIgnore
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @JsonIgnore
    public boolean isAttackRolls() {
        return attackRolls;
    }

    public void setAttackRolls(boolean attackRolls) {
        this.attackRolls = attackRolls;
    }

    @JsonIgnore
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @JsonIgnore
    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public String getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        this.savingThrow = savingThrow;
    }

    @JsonIgnore
    public String getHigherLevels() {
        return higherLevels;
    }

    public void setHigherLevels(String higherLevels) {
        this.higherLevels = higherLevels;
    }

    @JsonIgnore
    public Set<String> getSpellcasters() {
        return spellcasters;
    }

    public void setSpellcasters(Set<String> spellcasters) {
        this.spellcasters = spellcasters;
    }

    @JsonIgnore
    public String getSpellID() {
        return spellID;
    }

    public void setSpellID(String spellID) {
        this.spellID = spellID;
    }

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

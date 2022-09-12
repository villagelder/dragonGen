package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Armor {

    @JsonProperty("ARMORID")
    private String armorID;
    @JsonProperty("ARMORNAME")
    @JsonAlias("ARMOR")
    private String armorName;
    @JsonProperty("PROFICIENCY")
    private String proficiency;
    @JsonProperty("DRUIDIC")
    private boolean druidic;
    @JsonProperty("COST")
    private int cost;
    @JsonProperty("ARMORCLASS")
    @JsonAlias("AC")
    private int armorClass;
    @JsonProperty("DEXMAX")
    private int dexMax;
    @JsonProperty("MINSTR")
    private int minStr;
    @JsonProperty("STEALTH")
    private String stealth;
    @JsonProperty("WEIGHT")
    private int weight;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;

    @JsonIgnore
    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    @JsonIgnore
    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    @JsonIgnore
    public boolean isDruidic() {
        return druidic;
    }

    public void setDruidic(boolean druidic) {
        this.druidic = druidic;
    }

    @JsonIgnore
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @JsonIgnore
    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    @JsonIgnore
    public int getDexMax() {
        return dexMax;
    }

    public void setDexMax(int dexMax) {
        this.dexMax = dexMax;
    }

    @JsonIgnore
    public int getMinStr() {
        return minStr;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    @JsonIgnore
    public String getStealth() {
        return stealth;
    }

    public void setStealth(String stealth) {
        this.stealth = stealth;
    }

    @JsonIgnore
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public String getArmorID() {
        return armorID;
    }

    public void setArmorID(String armorID) {
        this.armorID = armorID;
    }
}



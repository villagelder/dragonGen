package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ElementalDisciplines {

    @JsonProperty("DISCIPLINE")
    private String discipline;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("KICOST")
    private int kicost;
    @JsonProperty("MINIMUMLEVEL")
    private int minimumLevel;
    @JsonProperty("SAVINGTHROW")
    private String savingThrow;
    @JsonProperty("RANGE")
    private int range;
    @JsonProperty("DAMAGE")
    private String damage;
    @JsonProperty("EFFECTS")
    private List<String> effects;
    @JsonProperty("DAMAGETYPE")
    private String damageType;
    @JsonProperty("SOURCE")
    private String source;

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKicost() {
        return kicost;
    }

    public void setKicost(int kicost) {
        this.kicost = kicost;
    }

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(int minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public String getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        this.savingThrow = savingThrow;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArcaneShotOptions {
    @JsonProperty("SHOTNAME")
    private String shotName;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SAVINGTHROW")
    private String savingThrow;
    @JsonProperty("EFFECTS")
    private List<String> effects;
    @JsonProperty("DAMAGE")
    private String damage;
    @JsonProperty("DAMAGE18THLEVEL")
    private String damage18thLevel;
    @JsonProperty("DAMAGETYPE")
    private String damageType;
    @JsonProperty("SOURCE")
    private String source;

    public String getShotName() {
        return shotName;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        this.savingThrow = savingThrow;
    }

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDamage18thLevel() {
        return damage18thLevel;
    }

    public void setDamage18thLevel(String damage18thLevel) {
        this.damage18thLevel = damage18thLevel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

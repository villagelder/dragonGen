package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PsionicPower {

    @JsonProperty("POWER")
    private String power;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SAVINGTHROW")
    private String savingThrow;
    @JsonProperty("TARGET")
    private String target;
    @JsonProperty("RANGE")
    private int range;
    @JsonProperty("DAMAGE")
    private String damage;
    @JsonProperty("DAMAGETYPE")
    private String damageType;
    @JsonProperty("SOURCE")
    private String source;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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

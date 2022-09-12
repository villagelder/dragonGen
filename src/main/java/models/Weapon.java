package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weapon {
    @JsonProperty("WEAPONID")
    private String weaponID;
    @JsonProperty("WEAPONNAME")
    @JsonAlias("WEAPON")
    private String weaponName;
    @JsonProperty("DESCRIPTION")
    private String descritpion;
    @JsonProperty("CATEGORY")
    private String category;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("COST")
    private double cost;
    @JsonProperty("DAMAGE")
    private String damage;
    @JsonProperty("DAMAGETYPE")
    @JsonAlias("DMGTYPE")
    private String damageType;
    @JsonProperty("WEIGHT")
    private double weight;
    @JsonProperty("LIGHT")
    private boolean light;
    @JsonProperty("HEAVY")
    private boolean heavy;
    @JsonProperty("FINESSE")
    private boolean finesse;
    @JsonProperty("TWOHANDED")
    private boolean twohanded;
    @JsonProperty("VERSATILE")
    private boolean versatile;
    @JsonProperty("THROWN")
    private boolean thrown;
    @JsonProperty("AMMUNITION")
    private boolean ammunition;
    @JsonProperty("REACH")
    private boolean reach;
    @JsonProperty("SPECIAL")
    private boolean special;
    @JsonProperty("LOADING")
    private boolean loading;
    @JsonProperty("SWORD")
    private boolean sword;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    @JsonIgnore
    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    @JsonIgnore
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonIgnore
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @JsonIgnore
    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @JsonIgnore
    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    @JsonIgnore
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    @JsonIgnore
    public boolean isHeavy() {
        return heavy;
    }

    public void setHeavy(boolean heavy) {
        this.heavy = heavy;
    }

    @JsonIgnore
    public boolean isFinesse() {
        return finesse;
    }

    public void setFinesse(boolean finesse) {
        this.finesse = finesse;
    }

    @JsonIgnore
    public boolean isTwohanded() {
        return twohanded;
    }

    public void setTwohanded(boolean twohanded) {
        this.twohanded = twohanded;
    }

    @JsonIgnore
    public boolean isVersatile() {
        return versatile;
    }

    public void setVersatile(boolean versatile) {
        this.versatile = versatile;
    }

    @JsonIgnore
    public boolean isThrown() {
        return thrown;
    }

    public void setThrown(boolean thrown) {
        this.thrown = thrown;
    }

    @JsonIgnore
    public boolean isAmmunition() {
        return ammunition;
    }

    public void setAmmunition(boolean ammunition) {
        this.ammunition = ammunition;
    }

    @JsonIgnore
    public boolean isReach() {
        return reach;
    }

    public void setReach(boolean reach) {
        this.reach = reach;
    }

    @JsonIgnore
    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    @JsonIgnore
    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    @JsonIgnore
    public boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
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
    public String getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(String weaponID) {
        this.weaponID = weaponID;
    }
}

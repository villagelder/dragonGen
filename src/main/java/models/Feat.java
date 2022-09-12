package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class Feat {
    @JsonProperty("FEATID")
    private String featID;
    @JsonProperty("NAME")
    @JsonAlias("FEAT")
    private String name;
    @JsonProperty("ABILITYOPTIONS")
    private Set<String> abilityOptions;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SHORTDESC")
    private String shortDesc;
    @JsonProperty("TINYDESC")
    private String tinyDesc;
    @JsonProperty("RESISTANCES")
    private Set<String> resistances;
    @JsonProperty("INITIATIVE")
    private int initiative;
    @JsonProperty("ADDEDSPEED")
    private int addedSpeed;
    @JsonProperty("ARMORPROFS")
    private Set<String> armorProfs;
    @JsonProperty("WEAPONPROFS")
    private Set<String> weaponProfs;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public String getShortDesc() {
        return shortDesc;
    }


    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @JsonIgnore
    public String getTinyDesc() {
        return tinyDesc;
    }


    public void setTinyDesc(String tinyDesc) {
        this.tinyDesc = tinyDesc;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }


    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public Set<String> getAbilityOptions() {
        return abilityOptions;
    }

    public void setAbilityOptions(Set<String> abilityOptions) {
        this.abilityOptions = abilityOptions;
    }

    @JsonIgnore
    public Set<String> getResistances() {
        return resistances;
    }

    public void setResistances(Set<String> resistances) {
        this.resistances = resistances;
    }

    @JsonIgnore
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @JsonIgnore
    public int getAddedSpeed() {
        return addedSpeed;
    }

    public void setAddedSpeed(int addedSpeed) {
        this.addedSpeed = addedSpeed;
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
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public String getFeatID() {
        return featID;
    }

    public void setFeatID(String featID) {
        this.featID = featID;
    }
}


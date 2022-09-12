package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeaponProficiency {

    @JsonProperty("WEAPONPROFID")
    private String weaponProfID;
    @JsonProperty("NAME")
    @JsonAlias("WPN_PROF")
    private String name;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("WEAPONS")
    private List<String> weapons;
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
    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
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
    public String getWeaponProfID() {
        return weaponProfID;
    }

    public void setWeaponProfID(String weaponProfID) {
        this.weaponProfID = weaponProfID;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArmorProficiency {

    @JsonProperty("ARMORPROFICIENCYID")
    private String armorProficiencyID;
    @JsonProperty("ARMORPROF")
    @JsonAlias("ARMOR_PROF")
    private String armorProf;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getArmorProf() {
        return armorProf;
    }

    public void setArmorProf(String armorProf) {
        this.armorProf = armorProf;
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

    public String getArmorProficiencyID() {
        return armorProficiencyID;
    }

    public void setArmorProficiencyID(String armorProficiencyID) {
        this.armorProficiencyID = armorProficiencyID;
    }
}

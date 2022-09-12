package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class Personality {
    @JsonProperty("PERSONALITYID")
    private String personalityID;
    @JsonProperty("BACKGROUND")
    private String background;
    @JsonProperty("TRAITS")
    private Set<String> traits;
    @JsonProperty("IDEALS")
    private Set<String> ideals;
    @JsonProperty("BONDS")
    private Set<String> bonds;
    @JsonProperty("FLAWS")
    private Set<String> flaws;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @JsonIgnore
    public Set<String> getTraits() {
        return traits;
    }

    public void setTraits(Set<String> traits) {
        this.traits = traits;
    }

    @JsonIgnore
    public Set<String> getIdeals() {
        return ideals;
    }

    public void setIdeals(Set<String> ideals) {
        this.ideals = ideals;
    }

    @JsonIgnore
    public Set<String> getBonds() {
        return bonds;
    }

    public void setBonds(Set<String> bonds) {
        this.bonds = bonds;
    }

    @JsonIgnore
    public Set<String> getFlaws() {
        return flaws;
    }

    public void setFlaws(Set<String> flaws) {
        this.flaws = flaws;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public String getPersonalityID() {
        return personalityID;
    }

    public void setPersonalityID(String personalityID) {
        this.personalityID = personalityID;
    }
}

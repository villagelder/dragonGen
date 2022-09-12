package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class Background {

    @JsonProperty("BACKGROUNDID")
    private String backgroundID;
    @JsonProperty("BACKGROUND")
    private String background;
    @JsonProperty("SPECIALTY")
    private String specialty;
    @JsonProperty("SHORTDESC")
    private String shortdesc;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SKILLS")
    private Set<String> skills;
    @JsonProperty("TOOLS")
    private String tools;
    @JsonProperty("FREETOOLS")
    private Set<String> freeTools;
    @JsonProperty("TOOLCHOICES")
    private Set<String> toolChoices;
    @JsonProperty("GOLD")
    private int gold;
    @JsonProperty("EQUIPMENT")
    private List<String> equipment;
    @JsonProperty("BONUSLANGS")
    private int bonuslangs;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("PAGE")
    private String page;

    @JsonIgnore
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @JsonIgnore
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @JsonIgnore
    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    @JsonIgnore
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    @JsonIgnore
    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    @JsonIgnore
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @JsonIgnore
    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    @JsonIgnore
    public int getBonuslangs() {
        return bonuslangs;
    }

    public void setBonuslangs(int bonuslangs) {
        this.bonuslangs = bonuslangs;
    }

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @JsonIgnore
    public Set<String> getFreeTools() {
        return freeTools;
    }

    public void setFreeTools(Set<String> freeTools) {
        this.freeTools = freeTools;
    }

    @JsonIgnore
    public Set<String> getToolChoices() {
        return toolChoices;
    }

    public void setToolChoices(Set<String> toolChoices) {
        this.toolChoices = toolChoices;
    }

    @JsonIgnore
    public String getBackgroundID() {
        return backgroundID;
    }

    public void setBackgroundID(String backgroundID) {
        this.backgroundID = backgroundID;
    }
}

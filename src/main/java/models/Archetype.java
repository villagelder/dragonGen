package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Archetype {
    @JsonProperty("ARCHETYPEID")
    private String archetypeId;
    @JsonProperty("ARCHETYPENAME")
    @JsonAlias("ARCHETYPE")
    private String archetypeName;
    @JsonProperty("SPELLABILITY")
    private String spellAbility;
    @JsonProperty("CLASSNAME")
    @JsonAlias("CLASS")
    private String className;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;

    @JsonIgnore
    public String getArchetypeName() {
        return archetypeName;
    }

    public void setArchetypeName(String archetypeName) {
        this.archetypeName = archetypeName;
    }

    @JsonIgnore
    public String getSpellAbility() {
        return spellAbility;
    }

    public void setSpellAbility(String spellAbility) {
        this.spellAbility = spellAbility;
    }

    @JsonIgnore
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
    public String getArchetypeID() {
        return archetypeId;
    }

    public void setArchetypeID(String archetypeID) {
        this.archetypeId = archetypeID;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpellsPerLevel {

    @JsonProperty("SPELLSPERLEVELID")
    private String spellsPerLevelID;
    @JsonProperty("CLASSNAME")
    private String className;
    @JsonProperty("CLASSLEVEL")
    private int classLevel;
    @JsonProperty("CANTRIPS")
    private int cantrips;
    @JsonProperty("SPELLSKNOWN")
    private int spellsKnown;
    @JsonProperty("LVL1")
    private int lvl1;
    @JsonProperty("LVL2")
    private int lvl2;
    @JsonProperty("LVL3")
    private int lvl3;
    @JsonProperty("LVL4")
    private int lvl4;
    @JsonProperty("LVL5")
    private int lvl5;
    @JsonProperty("LVL6")
    private int lvl6;
    @JsonProperty("LVL7")
    private int lvl7;
    @JsonProperty("LVL8")
    private int lvl8;
    @JsonProperty("LVL9")
    private int lvl9;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @JsonIgnore
    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    @JsonIgnore
    public int getCantrips() {
        return cantrips;
    }

    public void setCantrips(int cantrips) {
        this.cantrips = cantrips;
    }

    @JsonIgnore
    public int getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(int spellsKnown) {
        this.spellsKnown = spellsKnown;
    }

    @JsonIgnore
    public int getLvl1() {
        return lvl1;
    }

    public void setLvl1(int lvl1) {
        this.lvl1 = lvl1;
    }

    @JsonIgnore
    public int getLvl2() {
        return lvl2;
    }

    public void setLvl2(int lvl2) {
        this.lvl2 = lvl2;
    }

    @JsonIgnore
    public int getLvl3() {
        return lvl3;
    }

    public void setLvl3(int lvl3) {
        this.lvl3 = lvl3;
    }

    @JsonIgnore
    public int getLvl4() {
        return lvl4;
    }

    public void setLvl4(int lvl4) {
        this.lvl4 = lvl4;
    }

    @JsonIgnore
    public int getLvl5() {
        return lvl5;
    }

    public void setLvl5(int lvl5) {
        this.lvl5 = lvl5;
    }

    @JsonIgnore
    public int getLvl6() {
        return lvl6;
    }

    public void setLvl6(int lvl6) {
        this.lvl6 = lvl6;
    }

    @JsonIgnore
    public int getLvl7() {
        return lvl7;
    }

    public void setLvl7(int lvl7) {
        this.lvl7 = lvl7;
    }

    @JsonIgnore
    public int getLvl8() {
        return lvl8;
    }

    public void setLvl8(int lvl8) {
        this.lvl8 = lvl8;
    }

    @JsonIgnore
    public int getLvl9() {
        return lvl9;
    }

    public void setLvl9(int lvl9) {
        this.lvl9 = lvl9;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public String getSpellsPerLevelID() {
        return spellsPerLevelID;
    }

    public void setSpellsPerLevelID(String spellsPerLevelID) {
        this.spellsPerLevelID = spellsPerLevelID;
    }
    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class SpellBook {

    @JsonProperty("SPELLBOOKID")
    private String spellbookID;
    @JsonProperty("BOOKNAME")
    private String bookName;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("CASTER")
    private String caster;
    @JsonProperty("CANTRIPS")
    private Set<String> cantrips;
    @JsonProperty("SPELLSLEVEL1")
    private Set<String> spellsLevel1;
    @JsonProperty("SPELLSLEVEL2")
    private Set<String> spellsLevel2;
    @JsonProperty("SPELLSLEVEL3")
    private Set<String> spellsLevel3;
    @JsonProperty("SPELLSLEVEL4")
    private Set<String> spellsLevel4;
    @JsonProperty("SPELLSLEVEL5")
    private Set<String> spellsLevel5;
    @JsonProperty("SPELLSLEVEL6")
    private Set<String> spellsLevel6;
    @JsonProperty("SPELLSLEVEL7")
    private Set<String> spellsLevel7;
    @JsonProperty("SPELLSLEVEL8")
    private Set<String> spellsLevel8;
    @JsonProperty("SPELLSLEVEL9")
    private Set<String> spellsLevel9;
    @JsonProperty("SOURCE")
    private String source;
    @JsonProperty("AUTHOR")
    private String author;

    @JsonIgnore
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @JsonIgnore
    public String getSpellbookID() {
        return spellbookID;
    }

    public void setSpellbookID(String spellbookID) {
        this.spellbookID = spellbookID;
    }

    @JsonIgnore
    public Set<String> getCantrips() {
        return cantrips;
    }

    public void setCantrips(Set<String> cantrips) {
        this.cantrips = cantrips;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel1() {
        return spellsLevel1;
    }

    public void setSpellsLevel1(Set<String> spellsLevel1) {
        this.spellsLevel1 = spellsLevel1;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel2() {
        return spellsLevel2;
    }

    public void setSpellsLevel2(Set<String> spellsLevel2) {
        this.spellsLevel2 = spellsLevel2;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel3() {
        return spellsLevel3;
    }

    public void setSpellsLevel3(Set<String> spellsLevel3) {
        this.spellsLevel3 = spellsLevel3;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel4() {
        return spellsLevel4;
    }

    public void setSpellsLevel4(Set<String> spellsLevel4) {
        this.spellsLevel4 = spellsLevel4;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel5() {
        return spellsLevel5;
    }

    public void setSpellsLevel5(Set<String> spellsLevel5) {
        this.spellsLevel5 = spellsLevel5;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel6() {
        return spellsLevel6;
    }

    public void setSpellsLevel6(Set<String> spellsLevel6) {
        this.spellsLevel6 = spellsLevel6;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel7() {
        return spellsLevel7;
    }

    public void setSpellsLevel7(Set<String> spellsLevel7) {
        this.spellsLevel7 = spellsLevel7;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel8() {
        return spellsLevel8;
    }

    public void setSpellsLevel8(Set<String> spellsLevel8) {
        this.spellsLevel8 = spellsLevel8;
    }

    @JsonIgnore
    public Set<String> getSpellsLevel9() {
        return spellsLevel9;
    }

    public void setSpellsLevel9(Set<String> spellsLevel9) {
        this.spellsLevel9 = spellsLevel9;
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
    public String getCaster() {
        return caster;
    }

    public void setCaster(String caster) {
        this.caster = caster;
    }
}

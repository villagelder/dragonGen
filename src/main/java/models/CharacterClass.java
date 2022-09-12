package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CharacterClass {

    @JsonProperty("CLASSID")
    private String classID;
    @JsonProperty("CLASSNAME")
    private String className;
    @JsonProperty("ARCHETYPENAME")
    private String archetypeName;
    @JsonProperty("ARCHETYPESTART")
    private int archetypeStart;
    @JsonProperty("ARCHETYPES")
    private Set<String> archetypes;
    @JsonProperty("ABILITYORDER")
    private List<String> abilityOrder;
    @JsonProperty("DESCRIPTION")
    private String Description;
    @JsonProperty("ROLES")
    private List<String> roles;
    @JsonProperty("HITDIE")
    private int hitDie;
    @JsonProperty("AVERAGEHP")
    private int averageHP;
    @JsonProperty("PRIMARYABILITIES")
    private Set<String> primaryAbilities;
    @JsonProperty("ARMORPROFICIENCIES")
    private Set<String> armorProficiencies;
    @JsonProperty("WEAPONPROFICIENCIES")
    private Set<String> weaponProficiencies;
    @JsonProperty("TOOLSDESC")
    private String toolsDesc;
    @JsonProperty("NUMBEROFTOOLS")
    private int numberOfTools;
    @JsonProperty("FREETOOLS")
    private Set<String> freeTools;
    @JsonProperty("TOOLCHOICES")
    private Set<String> toolChoices;
    @JsonProperty("EQUIPMENTCHOICES")
    private Map<String, List<String>> equipmentChoices;
    @JsonProperty("EQUIPMENTFREE")
    private Set<String> equipmentFree;
    @JsonProperty("STARTINGFUNDS")
    private String startingFunds;
    @JsonProperty("FUNDSMULTIPLIER")
    private int fundsMultiplier;
    @JsonProperty("SAVEPROFICIENCIES")
    private Set<String> saveProficiencies;
    @JsonProperty("CLASSSKILLS")
    private Set<String> classSkills;
    @JsonProperty("NUMBEROFSKILLS")
    private int numberOfSkills;
    @JsonProperty("SPELLTYPE")
    private String spelltype;
    @JsonProperty("SPELLABILITY")
    private String spellAbility;
    @JsonProperty("RECOMMENDEDFEATS")
    private Set<String> recommendedFeats;
    @JsonProperty("FAVORITEBACKGROUNDS")
    private Set<String> favoriteBackgrounds;
    @JsonProperty("AUTHOR")
    private String author;
    @JsonProperty("SOURCE")
    private String source;

    @JsonIgnore
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonIgnore
    public int getArchetypeStart() {
        return archetypeStart;
    }

    public void setArchetypeStart(int archetypeStart) {
        this.archetypeStart = archetypeStart;
    }

    @JsonIgnore
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @JsonIgnore
    public String getArchetypeName() {
        return archetypeName;
    }

    public void setArchetypeName(String archetypeName) {
        this.archetypeName = archetypeName;
    }

    @JsonIgnore
    public Set<String> getArchetypes() {
        return archetypes;
    }

    public void setArchetypes(Set<String> archetypes) {
        this.archetypes = archetypes;
    }

    @JsonIgnore
    public List<String> getAbilityOrder() {
        return abilityOrder;
    }

    public void setAbilityOrder(List<String> abilityOrder) {
        this.abilityOrder = abilityOrder;
    }

    @JsonIgnore
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @JsonIgnore
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    @JsonIgnore
    public int getAverageHP() {
        return averageHP;
    }

    public void setAverageHP(int averageHP) {
        this.averageHP = averageHP;
    }

    @JsonIgnore
    public Set<String> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(Set<String> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    @JsonIgnore
    public Set<String> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(Set<String> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    @JsonIgnore
    public String getStartingFunds() {
        return startingFunds;
    }

    public void setStartingFunds(String startingFunds) {
        this.startingFunds = startingFunds;
    }

    @JsonIgnore
    public int getFundsMultiplier() {
        return fundsMultiplier;
    }

    public void setFundsMultiplier(int fundsMultiplier) {
        this.fundsMultiplier = fundsMultiplier;
    }

    @JsonIgnore
    public Set<String> getSaveProficiencies() {
        return saveProficiencies;
    }

    public void setSaveProficiencies(Set<String> saveProficiencies) {
        this.saveProficiencies = saveProficiencies;
    }

    @JsonIgnore
    public Set<String> getClassSkills() {
        return classSkills;
    }

    public void setClassSkills(Set<String> classSkills) {
        this.classSkills = classSkills;
    }

    @JsonIgnore
    public int getNumberOfSkills() {
        return numberOfSkills;
    }

    public void setNumberOfSkills(int numberOfSkills) {
        this.numberOfSkills = numberOfSkills;
    }

    @JsonIgnore
    public String getSpelltype() {
        return spelltype;
    }

    public void setSpelltype(String spelltype) {
        this.spelltype = spelltype;
    }

    @JsonIgnore
    public String getSpellAbility() {
        return spellAbility;
    }

    public void setSpellAbility(String spellAbility) {
        this.spellAbility = spellAbility;
    }

    @JsonIgnore
    public Set<String> getRecommendedFeats() {
        return recommendedFeats;
    }

    public void setRecommendedFeats(Set<String> recommendedFeats) {
        this.recommendedFeats = recommendedFeats;
    }

    @JsonIgnore
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public Set<String> getPrimaryAbilities() {
        return primaryAbilities;
    }

    public void setPrimaryAbilities(Set<String> primaryAbilities) {
        this.primaryAbilities = primaryAbilities;
    }

    @JsonIgnore
    public int getNumberOfTools() {
        return numberOfTools;
    }

    public void setNumberOfTools(int numberOfTools) {
        this.numberOfTools = numberOfTools;
    }

    @JsonIgnore
    public Set<String> getToolChoices() {
        return toolChoices;
    }

    public void setToolChoices(Set<String> toolChoices) {
        this.toolChoices = toolChoices;
    }

    @JsonIgnore
    public String getToolsDesc() {
        return toolsDesc;
    }

    public void setToolsDesc(String toolsDesc) {
        this.toolsDesc = toolsDesc;
    }

    @JsonIgnore
    public Set<String> getFavoriteBackgrounds() {
        return favoriteBackgrounds;
    }

    public void setFavoriteBackgrounds(Set<String> favoriteBackgrounds) {
        this.favoriteBackgrounds = favoriteBackgrounds;
    }

    @JsonIgnore
    public Set<String> getFreeTools() {
        return freeTools;
    }

    public void setFreeTools(Set<String> freeTools) {
        this.freeTools = freeTools;
    }

    @JsonIgnore
    public Set<String> getEquipmentFree() {
        return equipmentFree;
    }

    public void setEquipmentFree(Set<String> equipmentFree) {
        this.equipmentFree = equipmentFree;
    }

    @JsonIgnore
    public Map<String, List<String>> getEquipmentChoices() {
        return equipmentChoices;
    }

    public void setEquipmentChoices(Map<String, List<String>> equipmentChoices) {
        this.equipmentChoices = equipmentChoices;
    }

    @JsonIgnore
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}

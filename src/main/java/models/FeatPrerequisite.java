package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatPrerequisite {
    @JsonProperty("FPID")
    private int fpid;
    @JsonProperty("FEAT")
    private String feat;
    @JsonProperty("MINSTR")
    private int minStr;
    @JsonProperty("MINDEX")
    private int minDex;
    @JsonProperty("MINCON")
    private int minCon;
    @JsonProperty("MININT")
    private int minInt;
    @JsonProperty("MINWIS")
    private int minWis;
    @JsonProperty("MINCHA")
    private int minCha;
    @JsonProperty("SPELLCASTER")
    private boolean spellcaster;
    @JsonProperty("ARMORREQUIREMENT")
    @JsonAlias("ARMOR_REQ")
    private String armorRequirement;
    @JsonProperty("WEAPONREQUIREMENT")
    @JsonAlias("WEAPON_REQ")
    private String weaponRequirement;

    public int getFpid() {
        return fpid;
    }

    public void setFpid(int fpid) {
        this.fpid = fpid;
    }

    public String getFeat() {
        return feat;
    }

    public void setFeat(String feat) {
        this.feat = feat;
    }

    public int getMinStr() {
        return minStr;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    public int getMinDex() {
        return minDex;
    }

    public void setMinDex(int minDex) {
        this.minDex = minDex;
    }

    public int getMinCon() {
        return minCon;
    }

    public void setMinCon(int minCon) {
        this.minCon = minCon;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public int getMinWis() {
        return minWis;
    }

    public void setMinWis(int minWis) {
        this.minWis = minWis;
    }

    public int getMinCha() {
        return minCha;
    }

    public void setMinCha(int minCha) {
        this.minCha = minCha;
    }

    public boolean isSpellcaster() {
        return spellcaster;
    }

    public void setSpellcaster(boolean spellcaster) {
        this.spellcaster = spellcaster;
    }

    public String getArmorRequirement() {
        return armorRequirement;
    }

    public void setArmorRequirement(String armorRequirement) {
        this.armorRequirement = armorRequirement;
    }

    public String getWeaponRequirement() {
        return weaponRequirement;
    }

    public void setWeaponRequirement(String weaponRequirement) {
        this.weaponRequirement = weaponRequirement;
    }

}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BattleMasterManeuvers {

    @JsonProperty("MANEUVER")
    private String maneuver;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SAVINGTHROW")
    private String savingThrow;
    @JsonProperty("SOURCE")
    private String source;

    public String getManeuver() {
        return maneuver;
    }

    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        this.savingThrow = savingThrow;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

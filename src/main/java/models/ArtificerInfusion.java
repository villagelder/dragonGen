package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtificerInfusion {
    @JsonProperty("INFUSION")
    private String infusion;
    @JsonProperty("PREREQUISITE")
    private String prerequisite;
    @JsonProperty("REQUIREDLEVEL")
    private int requiredLevel;
    @JsonProperty("SOURCE")
    private String source;

    public String getInfusion() {
        return infusion;
    }

    public void setInfusion(String infusion) {
        this.infusion = infusion;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

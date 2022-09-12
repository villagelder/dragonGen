package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EldritchInvocations {

    @JsonProperty("INVOCATION")
    private String invocation;
    @JsonProperty("PREREQUISITE")
    private String prerequisite;
    @JsonProperty("REQUIREDLEVEL")
    private int requiredLevel;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SOURCE")
    private String source;

    public String getInvocation() {
        return invocation;
    }

    public void setInvocation(String invocation) {
        this.invocation = invocation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FightingStyle {

    @JsonProperty("STYLE")
    private String style;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("SOURCE")
    private String source;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

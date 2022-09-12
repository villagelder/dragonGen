package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MagicItem {

    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("RARITY")
    private String rarity;
    @JsonProperty("ITEM")
    private String item;
    @JsonProperty("SOURCE")
    private String source;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}

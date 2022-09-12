package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metamagic {

    @JsonProperty("METAMAGICNAME")
    private String metamagicName;
    @JsonProperty("POINTCOST")
    private int pointCost;
    @JsonProperty("DESCRIPTION")
    private String description;

}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class WildMagicSurge {

    @JsonProperty("TABLENAME")
    private String tableName;
    @JsonProperty("DICE")
    private String dice;
    @JsonProperty("TABLEDATA")
    private HashMap<Integer, String> tableData;
    @JsonProperty("SOURCE")
    private String source;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }

    public HashMap<Integer, String> getTableData() {
        return tableData;
    }

    public void setTableData(HashMap<Integer, String> tableData) {
        this.tableData = tableData;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

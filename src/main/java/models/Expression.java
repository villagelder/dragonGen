package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class Expression {

    @JsonProperty("SUBJECT")
    private String subject;

    @JsonProperty("METONYM")
    private Set<String> metonym;

    @JsonIgnore
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonIgnore
    public Set<String> getMetonym() {
        return metonym;
    }

    public void setMetonym(Set<String> metonym) {
        this.metonym = metonym;
    }
}

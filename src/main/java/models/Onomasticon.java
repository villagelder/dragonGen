package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Onomasticon {

    @JsonProperty("SUBJECT")
    private String subject;
    @JsonProperty("METONYM")
    private Set<String> metonym;
    @JsonProperty("ACTION")
    private Set<String> action;
    @JsonProperty("DESCRIPTOR")
    private Set<String> descriptor;
    @JsonProperty("SUBSTANTIVE")
    private Set<String> substantive;

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

    @JsonIgnore
    public Set<String> getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Set<String> descriptor) {
        this.descriptor = descriptor;
    }

    @JsonIgnore
    public Set<String> getSubstantive() {
        return substantive;
    }

    public void setSubstantive(Set<String> substantive) {
        this.substantive = substantive;
    }

    @JsonIgnore
    public Set<String> getAction() {
        return action;
    }

    public void setAction(Set<String> action) {
        this.action = action;
    }
}


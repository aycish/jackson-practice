package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JsonPropertyPerson {
    public int age;
    private String name;

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n"
                + "age: " + age;
    }
}

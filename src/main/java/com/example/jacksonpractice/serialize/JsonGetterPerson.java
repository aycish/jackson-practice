package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonGetterPerson {
    public int age;
    private String theName;

    @JsonGetter("name")
    public String getTheName() {
        return theName;
    }
}

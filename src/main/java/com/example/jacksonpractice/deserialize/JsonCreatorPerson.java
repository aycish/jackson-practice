package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCreatorPerson {
    public int age;
    public String name;

    @JsonCreator
    public JsonCreatorPerson(@JsonProperty("age") int age,
                             @JsonProperty("theName") String name) {
       this.age = age;
       this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + "age: " + this.age;
    }
}

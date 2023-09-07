package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class JsonSetterPerson {
    public String age;
    private String name;

    @JsonSetter("theName")
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("age")
    public void setAge(int age) {
        this.age = String.valueOf(age);
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + "age: " + this.age;
    }
}

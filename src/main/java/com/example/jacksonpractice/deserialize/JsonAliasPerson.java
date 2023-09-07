package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JsonAliasPerson {
    public int age;

    @JsonAlias({"theName", "p_name"})
    public String name;

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + "age: " + this.age;
    }
}

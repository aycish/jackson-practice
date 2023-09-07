package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JacksonInjectPerson {
    @JacksonInject
    public int age;
    public String name;

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + "age: " + this.age;
    }
}

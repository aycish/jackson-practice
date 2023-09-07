package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonUnwrappedPerson {
    public int age;

    @JsonUnwrapped
    public Name name;

    @AllArgsConstructor
    public static class Name {
        public String first;
        public String last;
    }
}

package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonRootNamePerson {
    public int age;
    public String name;
}

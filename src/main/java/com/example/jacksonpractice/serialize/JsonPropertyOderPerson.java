package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonPropertyOrder({"name", "age"})
public class JsonPropertyOderPerson {
    public int age;
    public String name;
}

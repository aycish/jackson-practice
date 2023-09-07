package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonFilter("unheeFilter")
public class JsonFilterPerson {
    public int age;
    public String name;
}

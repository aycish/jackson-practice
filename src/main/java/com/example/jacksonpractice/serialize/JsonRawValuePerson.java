package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonRawValuePerson {
    public String name;
    @JsonRawValue
    public String rawValue;
}

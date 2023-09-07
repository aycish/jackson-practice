package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class JsonSerializePerson {
    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date birthDate;
}

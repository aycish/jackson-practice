package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum JsonValueEnumType {
    TYPE1(1, "Type A"), TYPE2(2, "TYPE 2");

    private Integer id;
    private String name;

    @JsonValue
    public String getName() {
        return name;
    }
}

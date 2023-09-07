package com.example.jacksonpractice.serialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class JsonAnyGetterPerson {

    public String name;
    private Map<String, String> properties = new HashMap<>();

    public JsonAnyGetterPerson(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String key, String val) {
        this.properties.put(key, val);
    }
}

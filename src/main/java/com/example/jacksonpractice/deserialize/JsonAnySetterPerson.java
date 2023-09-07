package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class JsonAnySetterPerson {
    public String name;
    private Map<String, String> items = new HashMap<>();

    @JsonAnySetter
    public void add(String itemName, String quantity) {
        items.put(itemName, quantity);
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + items.toString();
    }
}

package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JsonBackReferencePerson {
    public int age;
    public String name;

    @JsonBackReference
    public List<JsonManagedReferenceItem> items;

    public void addItem(JsonManagedReferenceItem item) {
        items.add(item);
    }
}

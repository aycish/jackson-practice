package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name"
)
public class JsonIdentityInfoPerson {
    public int age;
    public String name;
    public List<JsonIdentityInfoItem> items;

    public void addItem(JsonIdentityInfoItem item) {
        items.add(item);
    }
}

package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class JsonIdentityInfoItem {
    public int id;
    public String itemName;
    public JsonIdentityInfoPerson owner;
}

package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonManagedReferenceItem {
    public int id;
    public String itemName;

    @JsonManagedReference
    public JsonBackReferencePerson owner;
}

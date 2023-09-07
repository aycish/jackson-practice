package com.example.jacksonpractice.deserialize;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class JsonDeserializePerson {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date birthDate;

    @Override
    public String toString() {
        return "name: " + this.name + "\n"
                + "birthDate: " + this.birthDate.toString();
    }
}

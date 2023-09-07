package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class JsonFormatPerson {
    public String name;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss"
    )
    public Date birthDate;
}

package com.example.jacksonpractice;

import com.example.jacksonpractice.serialize.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class SerializePractice {

    @Test
    void jsonAnyGetter_thenCorrect() throws JsonProcessingException {
        JsonAnyGetterPerson person = new JsonAnyGetterPerson("Unhee");
        person.add("age", "31");
        person.add("home", "yong-in");

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains("age", "31", "home", "yong-in");
    }

    @Test
    void jsonGetter_thenCorrect() throws JsonProcessingException {
        JsonGetterPerson person = new JsonGetterPerson(31, "Unhee");

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains("Unhee", "31");
    }

    @Test
    void jsonPropertyOrder_thenCorrect() throws JsonProcessingException {
        JsonPropertyOderPerson person = new JsonPropertyOderPerson(31, "Unhee");

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains("Unhee", "31");
    }

    @Test
    void jsonRawValue_thenCorrect() throws JsonProcessingException {
        JsonRawValuePerson person = new JsonRawValuePerson("Unhee", "{\"age\":31}");

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains("Unhee", "31");
    }

    @Test
    void jsonValue_thenCorrect() throws JsonProcessingException, IOException {
        String enumAsString = new ObjectMapper().writeValueAsString(JsonValueEnumType.TYPE1);
        System.out.println(enumAsString);
        assertThat(enumAsString).isEqualTo("\"Type A\"");
    }

    @Test
    void jsonRootName_thenCorrect() throws JsonProcessingException {
        JsonRootNamePerson person = new JsonRootNamePerson(31, "Unhee");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(person);

        System.out.println(result);
        assertThat(result).contains("person").contains("31", "Unhee");
    }

    @Test
    void jsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
        SimpleDateFormat bf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String toParse = "07-01-1994 01:33:13";
        Date date = bf.parse(toParse);
        JsonSerializePerson person = new JsonSerializePerson("Unhee", date);

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains(toParse, "Unhee");
    }
}
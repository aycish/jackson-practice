package com.example.jacksonpractice;

import com.example.jacksonpractice.deserialize.*;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DeserializePractice {

    @Test
    void jsonCreator_thenCorrect() throws IOException {
        String json = getJsonDataFromFile("person.json");

        JsonCreatorPerson expected = new JsonCreatorPerson(31, "Unhee");

        JsonCreatorPerson person = new ObjectMapper()
                .readerFor(JsonCreatorPerson.class)
                .readValue(json);

        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jacksonInject_thenCorrect() throws IOException {
        JacksonInjectPerson expected = new JacksonInjectPerson(91, "Unhee");

        String json = "{\"name\":\"Unhee\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 91);
        JacksonInjectPerson person = new ObjectMapper().reader(inject).forType(JacksonInjectPerson.class).readValue(json);

        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jsonAnySetter_thenCorrect() throws IOException {
        Map<String, String> expectedItems = Map.of("card", "3",
                "money", "19000");
        JsonAnySetterPerson expected = new JsonAnySetterPerson("Unhee", expectedItems);

        String json = getJsonDataFromFile("backpackers.json");
        JsonAnySetterPerson person = new ObjectMapper().readerFor(JsonAnySetterPerson.class).readValue(json);

        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jsonSetter_thenCorrect() throws IOException {
        JsonSetterPerson expected = new JsonSetterPerson("31", "Unhee");
        String json = getJsonDataFromFile("person.json");
        JsonSetterPerson person = new ObjectMapper().readerFor(JsonSetterPerson.class).readValue(json);

        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jsonDeserialize_thenCorrect() throws IOException, ParseException {
        SimpleDateFormat bf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "07-01-1994 01:30:33";
        Date date = bf.parse(toParse);
        JsonDeserializePerson expected = new JsonDeserializePerson("Unhee", date);

        String json = getJsonDataFromFile("id.json");
        JsonDeserializePerson person = new ObjectMapper().readerFor(JsonDeserializePerson.class).readValue(json);
        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jsonAlias_thenCorrect() throws IOException {
        JsonAliasPerson expected = new JsonAliasPerson(31, "Unhee");

        String json = getJsonDataFromFile("person.json");
        JsonAliasPerson person = new ObjectMapper().readerFor(JsonAliasPerson.class).readValue(json);
        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);

        json = getJsonDataFromFile("person2.json");
        person = new ObjectMapper().readerFor(JsonAliasPerson.class).readValue(json);
        System.out.println(person);

        assertThat(person).usingRecursiveComparison().isEqualTo(expected);

        json = getJsonDataFromFile("person3.json");
        person = new ObjectMapper().readerFor(JsonAliasPerson.class).readValue(json);
        System.out.println(person);
    }

    private static String getJsonDataFromFile(final String fileName) throws IOException {
        ClassLoader classLoader = DeserializePractice.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        assert resource != null;

        File jsonFile = new File(resource.getFile());
        return new String(Files.readAllBytes(jsonFile.toPath()));
    }
}

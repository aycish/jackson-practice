package com.example.jacksonpractice;

import com.example.jacksonpractice.general.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralAnnotationPractice {

    @Test
    void jsonProperty_thenCorrect() throws JsonProcessingException {
        JsonPropertyPerson expected = new JsonPropertyPerson(31, "Unhee");

        String result = new ObjectMapper().writeValueAsString(expected);
        System.out.println(result);
        assertThat(result).contains("31", "Unhee");

        JsonPropertyPerson person = new ObjectMapper().readerFor(JsonPropertyPerson.class).readValue(result);
        System.out.println(person);
        assertThat(person).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void jsonFormat_thenCorrect() throws JsonProcessingException, ParseException {
        SimpleDateFormat bf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        bf.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "07-01-1994 01:30:33";
        Date date = bf.parse(toParse);
        JsonFormatPerson person = new JsonFormatPerson("Unhee", date);

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);
        assertThat(result).contains(toParse);
    }

    @Test
    void jsonUnwrapped_thenCorrect() throws JsonProcessingException {
        JsonUnwrappedPerson.Name name = new JsonUnwrappedPerson.Name("Unhee", "Jo");
        JsonUnwrappedPerson person = new JsonUnwrappedPerson(31, name);

        String result = new ObjectMapper().writeValueAsString(person);
        System.out.println(result);

        assertThat(result).contains("Unhee", "Jo").doesNotContain("name");
    }

    @Test
    void jsonView_thenCorrect() throws JsonProcessingException {
        JsonViewItem item = new JsonViewItem(3, "cell-phone", "Unhee");

        String result = new ObjectMapper().writerWithView(UserViews.Public.class).writeValueAsString(item);
        System.out.println(result);

        assertThat(result).contains("3", "cell-phone").doesNotContain("Unhee");
    }

    @Test
    void jsonReference_thenCorrect() throws JsonProcessingException {
        JsonBackReferencePerson person = new JsonBackReferencePerson(31, "Unhee", new ArrayList<>());
        JsonManagedReferenceItem item = new JsonManagedReferenceItem(3, "book", person);
        JsonManagedReferenceItem item2 = new JsonManagedReferenceItem(4, "money", person);

        person.addItem(item);
        person.addItem(item2);

        String resultItem = new ObjectMapper().writeValueAsString(item);
        String resultItem2 = new ObjectMapper().writeValueAsString(item2);
        String resultPerson = new ObjectMapper().writeValueAsString(person);
        System.out.println(resultItem);
        System.out.println(resultItem2);
        System.out.println(resultPerson);

        assertThat(resultItem).contains("Unhee", "31");
    }

    @Test
    void jsonIdentityInfo_thenCorrect() throws JsonProcessingException {
        JsonIdentityInfoPerson person = new JsonIdentityInfoPerson(31, "Unhee", new ArrayList<>());
        JsonIdentityInfoItem item = new JsonIdentityInfoItem(1, "book", person);
        JsonIdentityInfoItem item2 = new JsonIdentityInfoItem(2, "card", person);

        person.addItem(item);
        person.addItem(item2);

        String resultItem = new ObjectMapper().writeValueAsString(item);
        String resultItem2 = new ObjectMapper().writeValueAsString(item);
        String resultPerson = new ObjectMapper().writeValueAsString(person);
        System.out.println(resultItem);
        System.out.println(resultItem2);
        System.out.println(resultPerson);

        assertThat(resultItem).contains("book", "Unhee", "items");
    }

    @Test
    void jsonFilter_thenCorrect() throws JsonProcessingException {
        JsonFilterPerson person = new JsonFilterPerson(31, "Unhee");
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                "unheeFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("name")
        );

        String result = new ObjectMapper().writer(filters).writeValueAsString(person);
        System.out.println(result);

        assertThat(result).contains("Unhee").doesNotContain("age", "31");
    }

    private static String getJsonDataFromFile(final String fileName) throws IOException {
        ClassLoader classLoader = DeserializePractice.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        assert resource != null;

        File jsonFile = new File(resource.getFile());
        return new String(Files.readAllBytes(jsonFile.toPath()));
    }
}

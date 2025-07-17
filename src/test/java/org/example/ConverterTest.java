package org.example;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @org.junit.jupiter.api.Test
    public void toJson() {
        Person person = new Person("Durgesh",21,200.0, Arrays.asList("chess","movies"));
        String jsonValue = Converter.toJson(person);

        assertTrue(jsonValue.contains("\"name\":\"Durgesh\""));  // no spacing due to no pretty printing
        assertTrue(jsonValue.contains("\"age\":21"));
        assertTrue(jsonValue.contains("\"balance\":200.0"));
        assertTrue(jsonValue.contains("chess"));

    }

    @org.junit.jupiter.api.Test
    public void fromJson() {
        String jsonValue ="""
                {
                  "name": "Durgesh",
                  "age": 21,
                  "balance": 200.00,
                  "interests": ["chess", "movies"]
                }
                """;
        Person person = Converter.fromJson(jsonValue);

        assertEquals("Durgesh",person.getName());
        assertEquals(21,person.getAge());
        assertEquals(200.00,person.getBalance());
        assertEquals(Arrays.asList("chess","movies"),person.getInterests());
    }
}
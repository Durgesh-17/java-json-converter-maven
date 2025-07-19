package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;


public class Converter {
    //json serializer
    public static String toJson(Person person){
        Gson gson = new Gson();
        String jsonString = gson.toJson(person);
        return jsonString;
    }

    //json deserializer
    public static Person fromJson(String jsonString){
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonString,Person.class);
        return person;
    }

    //xml serializer
    public static String toXml(Person person) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(person);
        return xmlString;
    }

    //xml deserializer
    public static Person fromXml(String xmlString) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = xmlMapper.readValue(xmlString, Person.class);
        return person;
    }

}
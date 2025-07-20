package org.example;
import org.example.HumanOuterClass.Human;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


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

    //proto serializer
    public static void toProto(Human human,String filePath){
        try {
            FileOutputStream output = new FileOutputStream(filePath);
            human.writeTo(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //proto deserializer
    public static Human fromProto(String filePath){
        try {
            FileInputStream input = new FileInputStream(filePath);
            return Human.parseFrom(input); //return type --> Human
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
package org.example;

import com.google.gson.Gson;

public class Converter {

    public static String toJson(Person person){
        Gson gson = new Gson();
        return gson.toJson(person);
    }

    public static Person fromJson(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,Person.class);
    }
}

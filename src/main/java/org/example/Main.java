package org.example;
import org.example.HumanOuterClass.Human;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;



public class Main {

    public static void main(String[] args) throws IOException {
        //Java
        Person personJava = new Person("Durgesh",21,200.01, Arrays.asList("chess","music","java"));

        String personJsonString = Converter.toJson(personJava);
        System.out.println(personJsonString);

        String filePathJson = "person_java.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePathJson), objectMapper.readTree(personJsonString));


        Person personJavaRestored = Converter.fromJson(personJsonString);

        System.out.println(personJavaRestored.getName());
        System.out.println(personJavaRestored.getAge());
        System.out.println(personJavaRestored.getBalance());
        System.out.println(personJavaRestored.getInterests());

        //xml
        Person personXml = new Person("Durgesh",21,200.01,Arrays.asList("chess","movies","xml"));

        String personXmlString = Converter.toXml(personXml);
        System.out.println(personXmlString);

        String filePathXml = "person_xml.xml";
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(filePathXml),personXml);

        Person personXmlRestored  = Converter.fromXml(personXmlString);

        System.out.println(personXmlRestored.getName());
        System.out.println(personXmlRestored.getAge());
        System.out.println(personXmlRestored.getBalance());
        System.out.println(personXmlRestored.getInterests());

        //protobuf
        Human.Builder humanBuilder = Human.newBuilder();
        humanBuilder.setName("Durgesh");
        humanBuilder.setAge(21);
        humanBuilder.setBalance(200.01);
        humanBuilder.addInterests("chess");
        humanBuilder.addInterests("movies");
        humanBuilder.addInterests("proto");


        Human human = humanBuilder.build();

        String filePath = "human.bin";

        byte[] humanData = human.toByteArray();

        Converter.toProto(human,filePath);

        Human deserializedHuman = Converter.fromProto(filePath);

        System.out.println(deserializedHuman.getName());
        System.out.println(deserializedHuman.getAge());
        System.out.println(deserializedHuman.getBalance());
        System.out.println(deserializedHuman.getInterestsList());
    }
}






package org.example;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private double balance;
    private List<String> interests;

    public Person(){};

    public Person(String name, int age, double balance, List<String> interests){
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.interests = interests;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package com.example.restservice.Models;

public class Person {
    String ID;
    String Name;
    Integer Age;

    public Person(){
        Name = "No Name";
        ID = "No ID";
        Age = 0;
    }

    public Person(String Name, String ID, Integer Age){
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Person -> ID : " + ID +  " Name : " + Name + " Age : " + Age;
    }
}

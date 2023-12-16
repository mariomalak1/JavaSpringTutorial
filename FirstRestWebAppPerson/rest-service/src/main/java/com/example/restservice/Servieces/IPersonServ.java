package com.example.restservice.Servieces;

import com.example.restservice.Models.Person;

import java.util.List;

public interface IPersonServ {
    boolean addPerson(Person p);
    boolean deletePerson(String ID);
    Person getPerson(String ID);

    List<Person> getAllPersons();
}

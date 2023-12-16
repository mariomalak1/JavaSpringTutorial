package com.example.restservice.Servieces;
import com.example.restservice.Models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.util.Random;


@Service
public class PersonServiceImpl implements IPersonServ{

    @Override
    public boolean addPerson(Person p) {
        if (Common.Persons.get(p.getID()) != null){
            return false;
        }
        Common.Persons.put(p.getID(), p);
        return true;
    }

    @Override
    public boolean deletePerson(String ID) {
        if (Common.Persons.get(ID) != null){
            Common.Persons.remove(ID);
            return true;
        }
        return false;
    }

    @Override
    public Person getPerson(String ID) {
        return Common.Persons.get(ID);
    }

    @Override
    public List<Person> getAllPersons() {
        Set<String> IDs = Common.Persons.keySet();
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (String id: IDs) {
            personArrayList.add(Common.Persons.get(id));
        }
        return personArrayList;
    }

    public Person dummyPerson(String Name){
        Random random = new Random();
        String id = String.valueOf(random.nextInt());
        Person person = new Person();
        person.setID(id);
        person.setAge(random.nextInt());
        person.setName(Name);
        return person;
    }
}

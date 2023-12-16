package com.example.restservice.Controllers;

import com.example.restservice.Models.Response;

import com.example.restservice.Models.Person;
import com.example.restservice.Servieces.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/")
public class PersonController {
    @Autowired
    PersonServiceImpl personService = new PersonServiceImpl();

    @PostMapping("/add")
     Response addPerson(@RequestParam String Name, @RequestParam String ID, @RequestParam Integer Age){
        Response response = new Response();
//        Person person = personService.dummyPerson(Name);
        Person person = new Person(Name, ID, Age);
        if (personService.addPerson(person)){
            response.setStatus(true);
            response.setMessage("Person With Data : " + person + " Added Successfully");
        }else{
            response.setStatus(false);
            response.setMessage("Person Already Exists");
        }
        return response;
    }

    @DeleteMapping("/delete/{ID}/")
    Response deletePerson(@PathVariable("ID") String ID){
        Response response = new Response();

        if (personService.deletePerson(ID)){
            response.setStatus(true);
            response.setMessage("Person Deleted Successfully");
        }else{
            response.setStatus(false);
            response.setMessage("Error While Deleting Person");
        }
        return response;
    }


    @GetMapping("/get/{id}/")
    Response getPerson(@PathVariable("id") String id){
        Response response = new Response();
        Person p = personService.getPerson(id);
        if(p != null){
            response.setMessage(p.toString());
            response.setStatus(true);
        }
        else {
            response.setMessage("Person With ID : " + id + " Not Found");
            response.setStatus(false);
        }
        return response;
    }

    @GetMapping("/get/")
    Response getPersons(){
        Response response = new Response();
        StringBuilder allPersons = new StringBuilder();
        List<Person> personList = personService.getAllPersons();
        for (Person p: personList) {
            System.out.println(p);
            allPersons.append(p.toString());
            allPersons.append("\n");
        }
        response.setMessage(allPersons.toString());
        response.setStatus(true);
        return response;
    }
}

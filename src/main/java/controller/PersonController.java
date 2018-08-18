package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.PersonRepository;

import java.util.List;
@CrossOrigin("*")
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public Person save(@RequestBody Person person){

        return personRepository.save(person);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getAll(){

        return (List<Person>) personRepository.findAll();
    }

}

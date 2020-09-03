package com.example.springboot01.controller;

import com.example.springboot01.Dao.PersonDao;
import com.example.springboot01.pojo.Person;
import com.example.springboot01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping(path = "addPerson")
    public void addPerson(@RequestBody Person person) {
        personService.save(person);
    }

    @RequestMapping(path = "delete")
    public void deletePerson(@RequestBody Long id) {
        personService.removeById(id);
    }
}

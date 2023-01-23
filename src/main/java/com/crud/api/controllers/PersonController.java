package com.crud.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.api.repositories.PersonRepository;

import jakarta.validation.Valid;

import com.crud.api.dto.PersonDTO;
import com.crud.api.model.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;
    
    @PostMapping
    public void createPerson(@RequestBody @Valid PersonDTO req){

        repository.save(new Person(req));
        System.out.println("OK");
    }

    @GetMapping
    public List<Person> listAll(){
       return repository.findAll();
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDTO req){
        repository.findById(id).map(person -> {
            person.setName(req.name());
            person.setLastname(req.lastname());
            person.setBithdate(req.birthdate());
            person.setPhone(req.phone());
            person.setEmail(req.email());
            return repository.save(person);
        });
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
       repository.deleteById(id);
    }
}

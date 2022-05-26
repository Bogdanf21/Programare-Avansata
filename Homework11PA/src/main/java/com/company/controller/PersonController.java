package com.company.controller;

import com.company.model.Person;
import com.company.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/get")
    public List<Person> getPersons ()
    {
        return personService.getPersons();
    }

    @PostMapping("/add")
    public ResponseEntity<String> savePerson (@RequestBody Person person)
    {
        if (person==null)
            return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
        personService.save(person);
        return new ResponseEntity<>("Person " + person.getName() + " created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody String name) {
        if (!personService.updatePerson(id,name))
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Person " + name + " created", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id)
    {
        if (!personService.deletePerson(id))
            return new ResponseEntity<>("Person with id " + id + " not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Person deleted", HttpStatus.OK);
    }

    @GetMapping("/mostPopular")
    public ResponseEntity<?> getMostPopularPersons(@RequestParam Integer n)
    {
        if(n<=0) return new ResponseEntity<>("Bad request.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(personService.getMostPopularNPersons(n),HttpStatus.OK);
    }


}

package com.company.service;

import com.company.model.Person;
import com.company.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService  {

    private final PersonRepository personRepo;


    public List<Person> getPersons() {
        return personRepo.findAll();
    }


    public void save(Person person) {
        personRepo.save(person);
    }


    public boolean updatePerson(Long id, String name) {
        Optional<Person> person = personRepo.findById(id);
        if (person.isPresent())
        {
            person.get().setName(name);
            personRepo.save(person.get());
            return true;
        }
        return false;
    }

    
    public boolean deletePerson(Long id) {
        Optional<Person> person = personRepo.findById(id);
        if (person.isPresent())
        {
            personRepo.delete(person.get());
            return true;
        }
        return false;
    }
}

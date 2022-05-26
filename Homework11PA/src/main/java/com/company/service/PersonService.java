package com.company.service;

import com.company.model.Person;
import com.company.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Set<Person> getMostPopularNPersons(Integer n) {
        return personRepo.getMostPopularNPersons(n);

    }

//    public Set<Person> getFriendsForPerson(Long id) throws NoSuchElementException {
//        Optional<Person> person = personRepo.findById(id);
//        if(!person.isPresent())
//            throw new NoSuchElementException("Person with id " + id + " not found");
//        return person.get().getFriends();
//    }

//    public void addFriendsForId(Long id, Set<Long> listOfIds) throws NoSuchElementException {
//        Optional<Person> initiatorOptional = personRepo.findById(id);
//
//        if(!initiatorOptional.isPresent())
//            throw new NoSuchElementException("Person with id " + id + " not found" );
//        Person initiator = initiatorOptional.get();
//
//List<Person> persons = personRepo.findAllById(listOfIds);
//        System.out.println(persons);
//        persons.stream().forEach(person ->{
//                initiator.addFriendshipWith(person);
//                personRepo.save(person);
//        });






  /*      Set<Person> toBeSaved = personRepo.findAllById(listOfIds).stream().map(person -> {
            person.getFriends().add(initiator);
            return person;
        }).collect(Collectors.toSet());
        personRepo.saveAllAndFlush(toBeSaved);
*/

  //  }


//    public void removeFriendsForId(Long id, Set<Long> listOfIds) throws NoSuchElementException {
//        Optional<Person> initiatorOptional = personRepo.findById(id);
//        if(!initiatorOptional.isPresent())
//            throw new NoSuchElementException("Person with id " + id + " not found" );
//        Person initiator = initiatorOptional.get();
//
//
//        listOfIds.stream().forEach(friendId -> {
//            Optional<Person> friend = personRepo.findById(friendId);
//            if(!friend.isPresent())
//                throw new NoSuchElementException("Person with id " + friendId + " not found" );
//            initiator.removeFriendshipWith(friend.get());
//        });
//    }
//
//    public Set<Person> getMostPopularPersons(Integer n) {
//        List<Person> repo =  personRepo.findAll();
//        PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>(Comparator.comparingInt(o -> o.getFriends().size()));
//        priorityQueue.addAll(repo);
//        Set<Person> response = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            if(priorityQueue.peek() == null) return response;
//            response.add(priorityQueue.poll());
//        }
//        return response;

  //  }
}

package com.company.service;

import com.company.model.Person;
import com.company.repository.FriendshipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FriendshipService{

    private final FriendshipRepository friendshipRepository;
    public List<Person> getFriends(Long id) {
        Optional<Person> personById = friendshipRepository.findById(id);
        return personById.map(Person::getFriends).orElse(null);

    }

    public boolean saveFriend(Long id, String name) {
        Optional<Person> personById = friendshipRepository.findById(id);
        if (personById.isPresent())
        {
            List<Person> personByName = friendshipRepository.findByName(name);
            if (!personByName.isEmpty())
            {
                Person tempPerson = personByName.get(0);
                if (!personById.get().getFriends().contains(tempPerson)) {
                    personById.get().addFriend(tempPerson);
                    personById.get().setNumberOfFriends(personById.get().getNumberOfFriends() + 1);
                    tempPerson.addFriend(personById.get());
                    tempPerson.setNumberOfFriends(tempPerson.getNumberOfFriends() + 1);
                    friendshipRepository.save(personById.get());
                    return true;
                }
            }
        }
        return false;
    }

}

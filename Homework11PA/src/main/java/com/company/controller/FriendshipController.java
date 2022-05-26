package com.company.controller;

import com.company.model.Person;
import com.company.service.FriendshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person/friends")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonFriends (@PathVariable Long id)
    {
        List<Person> friends = friendshipService.getFriends(id);
        if (friends.isEmpty())
        {
            return new ResponseEntity<>("The person doesnt have any friends.",HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(friends);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> saveFriend (@PathVariable Long id, @RequestParam String name)
    {
        if (name==null)
            return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
        if (!friendshipService.saveFriend(id,name))
            return new ResponseEntity<>("Cannot add friend.", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Friend added successfully", HttpStatus.CREATED);
    }

}

package com.udemy.rest.webservices.udemywebservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //retrieve all users /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return service.allusers();
    }


    //retrieve specific user with ID
    @GetMapping("/users/{id}")
    public User retrieveSpecificUser(@PathVariable Integer id)
    {
        User checkUser = service.findUser(id);
        if(checkUser==null)
            throw new UserNotFoundException("user id: "+ id);
        else
            return checkUser;
    }

    //post request; adding user into Db so input is mentioned in the request body. in the response header getting the uri of the added user(users/{id}) in the location field.
    @PostMapping("/users")
    public ResponseEntity addingUserToDb(@Valid @RequestBody User userobj)
    {
        User newlyCreatedUser= service.addUser(userobj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newlyCreatedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

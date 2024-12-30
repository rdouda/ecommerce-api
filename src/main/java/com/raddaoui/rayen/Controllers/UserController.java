package com.raddaoui.rayen.Controllers;

import com.raddaoui.rayen.Serives.UserImplementation;
import com.raddaoui.rayen.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserImplementation userImplementation;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return userImplementation.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        return userImplementation.findById(id);
    }

    @PostMapping(path = "/create", consumes = MediaType.ALL_VALUE, produces  = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        return userImplementation.save(user);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user){
        return userImplementation.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id){
        return userImplementation.delete(id);
    }

}

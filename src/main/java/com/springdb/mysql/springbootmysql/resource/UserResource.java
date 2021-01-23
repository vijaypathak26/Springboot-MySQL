package com.springdb.mysql.springbootmysql.resource;

import com.springdb.mysql.springbootmysql.model.Users;
import com.springdb.mysql.springbootmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/all")
    public List<Users> getAllUser(){
        return userRepository.findAll();
        
    }

    @PostMapping(value="/load")
       public Users loadData(@RequestBody final Users users) {
       userRepository.save(users);
       return userRepository.findByName(users.getName());

    }
}

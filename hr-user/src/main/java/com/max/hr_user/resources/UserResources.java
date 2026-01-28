package com.max.hr_user.resources;

import com.max.hr_user.entities.User;
import com.max.hr_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}

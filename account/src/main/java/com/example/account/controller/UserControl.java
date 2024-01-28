package com.example.account.controller;

import com.example.account.dto.response.UserResponse;
import com.example.account.entity.User;
import com.example.account.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/account/user")
public class UserControl {



   private final UserService service;

    public UserControl(UserService service) {
        this.service = service;
    }
    @PostConstruct
    void init(){
        User user = new User();
        user.setUserId(ThreadLocalRandom.current().nextInt());
        user.setUsername("ahmet");
        user.setPassword("12345");
        add(user);
    }


    @PostMapping
    public ResponseEntity<UserResponse> add(@RequestBody User request){
        UserResponse response = service.add(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> get(){
        List<UserResponse> response = service.get();
        return ResponseEntity.ok(response);
    }


}


package com.example.account.service;

import com.example.account.dto.response.UserResponse;
import com.example.account.entity.User;
import com.example.account.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse add(User request) {
        return userModelToUserResponseDto(userRepository.save(request));
    }


    public UserResponse userModelToUserResponseDto(User user){
        UserResponse response = new UserResponse();
        response.username = user.getUsername();
        response.storeName = response.username + " Store";
        return response;
    }
    public List<UserResponse> get(){
        return userModelListToUserResponseList(userRepository.findAll());
    }

    private List<UserResponse> userModelListToUserResponseList(List<User> users) {
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user:users){
            userResponseList.add(userModelToUserResponseDto(user));
        }

        return userResponseList;
    }


}

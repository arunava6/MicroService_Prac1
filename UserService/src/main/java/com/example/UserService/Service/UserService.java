package com.example.UserService.Service;

import com.example.UserService.Entity.User;
import com.example.UserService.Payloads.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(User user);

    List<UserResponse> getAllUsers();

    UserResponse getUser(String userId);

    void deleteUser(String userId);

}

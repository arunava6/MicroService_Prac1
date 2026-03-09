package com.example.UserService.Service.Impl;

import com.example.UserService.Entity.User;
import com.example.UserService.Exception.ResourceNotFoundException;
import com.example.UserService.Payloads.UserResponse;
import com.example.UserService.Repository.UserRepo;
import com.example.UserService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public UserResponse createUser(User user) {
        User newUser = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(user.getName())
                .email(user.getEmail())
                .about(user.getAbout())
                .createdAt(LocalDateTime.now())
                .build();

        userRepo.save(newUser);
        return convertToUserResponse(newUser);
    }

    private UserResponse convertToUserResponse(User newUser) {
        return UserResponse.builder()
                .userId(newUser.getUserId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .about(newUser.getAbout())
                .createdAt(newUser.getCreatedAt())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return userList.stream()
                .map(user -> convertToUserResponse(user))
                .toList();

    }

    @Override
    public UserResponse getUser(String userId) {
        User existingUser=userRepo.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("User Id not found")
        );
        return convertToUserResponse(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        User existingUser=userRepo.findByUserId(userId).orElseThrow(
                ()->new ResourceNotFoundException("User Id not found")
        );
        userRepo.delete(existingUser);
    }

}

package com.example.UserService.Controller;

import com.example.UserService.Entity.User;
import com.example.UserService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED).body(userService.createUser(user));

    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "message", "Deleted Successfully", "timestamp", LocalDateTime.now()
        ));
    }

}

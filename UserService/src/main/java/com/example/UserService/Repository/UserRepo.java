package com.example.UserService.Repository;

import com.example.UserService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserId(String userId);

}

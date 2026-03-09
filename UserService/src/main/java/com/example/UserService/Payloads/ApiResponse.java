package com.example.UserService.Payloads;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private int errorCode;
    private LocalDateTime timeStamp;
}


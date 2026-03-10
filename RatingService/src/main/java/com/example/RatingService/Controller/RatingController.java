package com.example.RatingService.Controller;

import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }

    @GetMapping
    public ResponseEntity<?> getAllRating(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByUser(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<?> getRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByHotel(hotelId));
    }
}



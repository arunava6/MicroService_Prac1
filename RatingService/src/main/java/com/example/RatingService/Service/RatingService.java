package com.example.RatingService.Service;

import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Payload.RatingResponse;

import java.util.List;

public interface RatingService {

    RatingResponse addRating(Rating rating);

    List<RatingResponse> getAllRatings();

    List<RatingResponse> getAllRatingByUser(String userId);

    List<RatingResponse> getAllRatingByHotel(String hotelId);

}

package com.example.RatingService.Service.Impl;

import com.example.RatingService.Entity.Rating;
import com.example.RatingService.Payload.RatingResponse;
import com.example.RatingService.Repositories.RatingRepo;
import com.example.RatingService.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepo ratingRepo;

    @Override
    public RatingResponse addRating(Rating rating) {
        Rating newRating = Rating.builder()
                .ratingId(UUID.randomUUID().toString())
                .userId(rating.getUserId())
                .hotelId(rating.getHotelId())
                .rating(rating.getRating())
                .feedback(rating.getFeedback())
                .createdAt(LocalDateTime.now())
                .build();

        ratingRepo.save(newRating);
        return convertToRatingResponse(newRating);
    }

    @Override
    public List<RatingResponse> getAllRatings() {
        List<Rating> ratingList = ratingRepo.findAll();
        return ratingList.stream()
                .map(item -> convertToRatingResponse(item))
                .toList();

    }

    @Override
    public List<RatingResponse> getAllRatingByUser(String userId) {
        List<Rating> ratingList = ratingRepo.findRatingByUserId(userId);
        return ratingList.stream()
                .map(item -> convertToRatingResponse(item))
                .toList();
    }

    @Override
    public List<RatingResponse> getAllRatingByHotel(String hotelId) {
        List<Rating> ratingList = ratingRepo.findRatingByHotelId(hotelId);
        return ratingList.stream()
                .map(item -> convertToRatingResponse(item))
                .toList();

    }

    private RatingResponse convertToRatingResponse(Rating newRating) {
        return RatingResponse.builder()
                .ratingId(newRating.getRatingId())
                .userId(newRating.getUserId())
                .hotelId(newRating.getHotelId())
                .rating(newRating.getRating())
                .feedback(newRating.getFeedback())
                .createdAt(newRating.getCreatedAt())
                .build();
    }
}


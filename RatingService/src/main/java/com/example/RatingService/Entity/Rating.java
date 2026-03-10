package com.example.RatingService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user_rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
    private String ratingId;

    private String hotelId;
    private String userId;
    private Double rating;
    private String feedback;
    private LocalDateTime createdAt;
}

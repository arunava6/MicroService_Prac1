package com.example.UserService.Payloads;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingResponse {
    private String ratingId;
    private String hotelId;
    private String userId;
    private Double rating;
    private String feedback;
    private HotelResponse hotel;
}


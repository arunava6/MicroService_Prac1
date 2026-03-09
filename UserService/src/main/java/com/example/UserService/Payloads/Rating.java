package com.example.UserService.Payloads;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String hotelId;
    private String userId;
    private String rating;
    private String feedback;

}

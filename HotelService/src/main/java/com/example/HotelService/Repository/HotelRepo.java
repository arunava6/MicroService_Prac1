package com.example.HotelService.Repository;

import com.example.HotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
    Optional<Hotel> findByHotelId(String hotelId);
}

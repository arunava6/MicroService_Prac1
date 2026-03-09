package com.example.HotelService.Service.Impl;

import com.example.HotelService.Entity.Hotel;
import com.example.HotelService.Exception.ResourceNotFoundException;
import com.example.HotelService.Payloads.HotelResponse;
import com.example.HotelService.Repository.HotelRepo;
import com.example.HotelService.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepo hotelRepo;

    @Override
    public HotelResponse addHotel(Hotel hotel) {
        Hotel newHotel = Hotel.builder()
                .hotelId(UUID.randomUUID().toString())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .about(hotel.getAbout())
                .createdAt(LocalDateTime.now())
                .build();

        hotelRepo.save(newHotel);
        return convertToHotelResponse(newHotel);
    }

    private HotelResponse convertToHotelResponse(Hotel newHotel) {
        return HotelResponse.builder()
                .hotelId(newHotel.getHotelId())
                .name(newHotel.getName())
                .location(newHotel.getLocation())
                .about(newHotel.getAbout())
                .createdAt(newHotel.getCreatedAt())
                .build();
    }

    @Override
    public List<HotelResponse> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll();

        return hotels.stream()
                .map(hotel -> convertToHotelResponse(hotel))
                .toList();
    }

    @Override
    public HotelResponse getHotel(String hotelId) {
        Hotel existingHotel = hotelRepo.findByHotelId(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("Hotel Id not found")
        );
        return convertToHotelResponse(existingHotel);

    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel existingHotel = hotelRepo.findByHotelId(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("Hotel Id not found")
        );
        hotelRepo.delete(existingHotel);
    }
}

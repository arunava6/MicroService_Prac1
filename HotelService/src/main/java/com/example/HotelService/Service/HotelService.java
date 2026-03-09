package com.example.HotelService.Service;

import com.example.HotelService.Entity.Hotel;
import com.example.HotelService.Payloads.HotelResponse;

import java.util.List;

public interface HotelService {

    HotelResponse addHotel(Hotel hotel);

    List<HotelResponse> getAllHotels();

    HotelResponse getHotel(String hotelId);

    void deleteHotel(String hotelId);

}



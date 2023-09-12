package com.lcwd.holtel.HotelService.Service;

import java.util.List;
import java.util.Optional;

import com.lcwd.holtel.HotelService.Entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String hotelId);
}

package com.lcwd.holtel.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.holtel.HotelService.Entity.Hotel;



public interface HotelRepository extends JpaRepository<Hotel, String>{

}

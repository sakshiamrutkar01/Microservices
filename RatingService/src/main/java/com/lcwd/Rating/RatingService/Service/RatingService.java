package com.lcwd.Rating.RatingService.Service;
import org.springframework.stereotype.Service;

import com.lcwd.Rating.RatingService.Entity.Rating;

import java.util.List;

@Service
public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);




}
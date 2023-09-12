package com.lcwd.Rating.RatingService.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.Rating.RatingService.Entity.Rating;
import com.lcwd.Rating.RatingService.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository Ratingrepository;

    @Override
    public Rating create(Rating rating) {
        return Ratingrepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return Ratingrepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return Ratingrepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return Ratingrepository.findByHotelId(hotelId);
    }

	
	}


package com.lcwd.user.service.UserService.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.Entity.Hotel;
import com.lcwd.user.service.UserService.Entity.Rating;
import com.lcwd.user.service.UserService.Entity.User;
import com.lcwd.user.service.UserService.Exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub

		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
 
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server" + userId));
//		  ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), ArrayList.class);
//		  user.setRatings(ratingsOfUser);

		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {

			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId() ,Hotel.class);
			Hotel hotel = forEntity.getBody();

			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

}

package com.example.restaurant.controller;

import com.example.restaurant.dto.RestaurantDTO;
import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.mapper.RestaurantMapper;
import com.example.restaurant.repositories.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/restaurant")
@CrossOrigin("*")
public class RestaurantController {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Restaurant>> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        restaurant = restaurantRepo.save(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            RestaurantDTO restaurantDto =  RestaurantMapper.RESTAURANT_MAPPER.restaurantToRestaurantDTO(restaurant.get());
            return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

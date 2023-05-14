package com.example.restaurant.controller;

import com.example.restaurant.entity.Restaurant;
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
    public ResponseEntity<Restaurant> findRestaurantById(@PathVariable Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
    }
}

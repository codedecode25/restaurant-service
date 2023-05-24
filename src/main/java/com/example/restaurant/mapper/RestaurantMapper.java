package com.example.restaurant.mapper;

import com.example.restaurant.dto.RestaurantDTO;
import com.example.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper RESTAURANT_MAPPER = Mappers.getMapper(RestaurantMapper.class);

    Restaurant restaurantDTOToRestaurant(RestaurantDTO restaurantDto);

    RestaurantDTO restaurantToRestaurantDTO(Restaurant restaurant);




}

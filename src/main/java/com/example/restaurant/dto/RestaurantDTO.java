package com.example.restaurant.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO  implements Serializable {

    private int id;

    private String name;

    private String address;

    private String city;

    private String restaurantDescription;
}

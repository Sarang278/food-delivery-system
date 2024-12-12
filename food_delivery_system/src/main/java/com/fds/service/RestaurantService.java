package com.fds.service;


import com.fds.entity.Restaurant;
import java.util.List;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);
    Restaurant updateRestaurant(Long id, Restaurant restaurant);
    void deleteRestaurant(Long id);
}


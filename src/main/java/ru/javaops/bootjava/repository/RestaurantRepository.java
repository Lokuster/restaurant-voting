package ru.javaops.bootjava.repository;

import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.model.User;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getAll();

    Restaurant get(int id);

    void delete(int id);

    Restaurant save(Restaurant restaurant);

    void vote(int restaurantId, User user);
}

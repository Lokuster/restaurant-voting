package ru.javaops.bootjava.web.restaurant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.repository.DishRepository;
import ru.javaops.bootjava.repository.RestaurantRepository;
import ru.javaops.bootjava.to.RestaurantTo;

import java.util.List;

import static ru.javaops.bootjava.util.RestaurantsUtil.asTo;

@RestController
@RequestMapping(value = "/user/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class RestaurantUIController {
    private RestaurantRepository repository;
    private DishRepository dishRepository;

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("restaurantTo getAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantTo getRestaurantMenus(@PathVariable Integer id) {
        log.info("get restaurantTo with id {}", id);
        return asTo(repository.findById(id).orElse(null), dishRepository.findDishByRestaurantId(id));
    }
}

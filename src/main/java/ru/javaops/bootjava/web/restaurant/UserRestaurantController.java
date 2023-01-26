package ru.javaops.bootjava.web.restaurant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.model.User;
import ru.javaops.bootjava.repository.DishRepository;
import ru.javaops.bootjava.repository.RestaurantRepository;
import ru.javaops.bootjava.to.RestaurantTo;
import ru.javaops.bootjava.web.AuthUser;

import java.util.List;

import static ru.javaops.bootjava.util.RestaurantsUtil.asTo;

@RestController
@RequestMapping(value = UserRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class UserRestaurantController {
    static final String REST_URL = "/api/user/restaurants";

    private final RestaurantRepository repository;
    private final DishRepository dishRepository;

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("restaurant getAll");
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public RestaurantTo get(@PathVariable Integer id) {
        //TODO get restaurant's menu BY CURRENT DATE
        log.info("get restaurantTo with id {}", id);
        return asTo(repository.get(id), dishRepository.findDishByRestaurantId(id));
    }

    @PostMapping("/vote/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vote(@PathVariable int id, @AuthenticationPrincipal AuthUser authUser) {
        User user = authUser.getUser();
        log.info("user with id {} vote for restaurant with id {}", user.getId(), id);
        repository.vote(id, user);
    }
}

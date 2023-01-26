package ru.javaops.bootjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import ru.javaops.bootjava.error.AppException;
import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final CrudRestaurantRepository repository;
    private final UserRepository userRepository;
    private static final LocalTime CAN_CHANGE_VOTE_BEFORE_TIME = LocalTime.of(11, 0);

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteExisted(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void vote(int restaurantId, User user) {
        Restaurant userRestaurant = user.getRestaurant();
        if (userRestaurant != null && userRestaurant.id() == restaurantId) {
            throw new AppException(HttpStatus.BAD_REQUEST, String.format("User with id = %d has already voted for restaurant with id = %d today", user.id(), restaurantId));
        }
        if (userRestaurant == null
                || user.getVoteDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())) {
            repository.getExisted(restaurantId);
            repository.incrementVoteCount(restaurantId);
            userRepository.updateUserAfterVote(restaurantId, new Date(), user.id());
        } else if (LocalTime.now().isBefore(CAN_CHANGE_VOTE_BEFORE_TIME)) {
            repository.getExisted(restaurantId);
            repository.decrementVoteCount(userRestaurant.id());
            repository.incrementVoteCount(restaurantId);
            userRepository.updateUserAfterVote(restaurantId, new Date(), user.id());
        } else {
            throw new AppException(HttpStatus.BAD_REQUEST, String.format("User with id = %d has already voted today", user.id()));
        }
    }
}

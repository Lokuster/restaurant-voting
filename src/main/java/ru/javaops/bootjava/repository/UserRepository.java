package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.User;

import java.util.Date;
import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User> {
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findByEmailIgnoreCase(String email);

    @Modifying
    @Query("UPDATE User u SET u.restaurant.id = :restaurantId, u.voteDate = :date WHERE u.id = :id")
    void updateUserAfterVote(int restaurantId, Date date, int id);
}
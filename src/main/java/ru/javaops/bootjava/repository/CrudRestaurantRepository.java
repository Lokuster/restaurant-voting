package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.Restaurant;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends BaseRepository<Restaurant> {
    @Modifying
    @Query("UPDATE Restaurant r SET r.voteCount = r.voteCount + 1 WHERE r.id = :id")
    void incrementVoteCount(int id);

    @Modifying
    @Query("UPDATE Restaurant r SET r.voteCount = r.voteCount - 1 WHERE r.id = :id")
    void decrementVoteCount(int id);
}

package ru.javaops.bootjava.repository;

import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.model.User;

public interface VoteRepository {
    void vote(User user, Restaurant restaurant);
}

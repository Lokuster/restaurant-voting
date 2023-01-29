package ru.javaops.bootjava.web.vote;

import ru.javaops.bootjava.model.Vote;

import java.util.Date;

import static ru.javaops.bootjava.web.restaurant.RestaurantTestData.firstRestaurant;
import static ru.javaops.bootjava.web.restaurant.RestaurantTestData.secondRestaurant;
import static ru.javaops.bootjava.web.user.UserTestData.firstUser;
import static ru.javaops.bootjava.web.user.UserTestData.secondUser;

public class VoteTestData {
    public static final int FIRST_VOTE_ID = 1;
    public static final int SECOND_VOTE_ID = 2;

    public static final int NOT_FOUND = 100;

    public static final Vote firstVote = new Vote(FIRST_VOTE_ID, firstUser, firstRestaurant, new Date());
    public static final Vote secondVote = new Vote(SECOND_VOTE_ID, secondUser, secondRestaurant, new Date());

}

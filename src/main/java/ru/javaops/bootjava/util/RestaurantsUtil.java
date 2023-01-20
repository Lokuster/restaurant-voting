package ru.javaops.bootjava.util;

import lombok.experimental.UtilityClass;
import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.model.Restaurant;
import ru.javaops.bootjava.to.RestaurantTo;

import java.util.List;

@UtilityClass
public class RestaurantsUtil {
    public static RestaurantTo asTo(Restaurant restaurant, List<Dish> dishList) {
        if (restaurant == null) {
            return null;
        }
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getVoteCount(), MenusUtil.listAsTo(dishList));
    }
}

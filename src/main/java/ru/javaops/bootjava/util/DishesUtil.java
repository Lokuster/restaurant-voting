package ru.javaops.bootjava.util;

import lombok.experimental.UtilityClass;
import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.to.DishTo;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DishesUtil {
    public static DishTo asTo(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getPrice());
    }

    public static List<DishTo> listAsTo(List<Dish> dishList) {
        return dishList.stream().map(DishesUtil::asTo).collect(Collectors.toList());
    }
}

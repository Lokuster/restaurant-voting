package ru.javaops.bootjava.to;

import java.util.List;

public class RestaurantTo extends NamedTo {
    private List<DishTo> menu;

    public RestaurantTo(Integer id, String name, List<DishTo> menu) {
        super(id, name);
        this.menu = menu;
    }
}

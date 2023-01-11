package ru.javaops.bootjava.web.dish;

import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.web.MatcherFactory;

import java.util.List;

public class DishTestData {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingEqualsComparator(Dish.class);
    public static final int NOT_FOUND = 100;
    public static final int FIRST_DISH_ID = 1;
    public static final int SECOND_DISH_ID = 2;
    public static final int THIRD_DISH_ID = 3;
    public static final int FOURTH_DISH_ID = 4;
    public static final int FIRTH_DISH_ID = 5;
    public static final int SIXTH_DISH_ID = 6;

    public static final Dish firstDish = new Dish(FIRST_DISH_ID, "Beef Stroganoff", 100);
    public static final Dish secondDish = new Dish(SECOND_DISH_ID, "Reuben", 250);
    public static final Dish thirdDish = new Dish(THIRD_DISH_ID, "Sandwich", 200);
    public static final Dish fourthDish = new Dish(FOURTH_DISH_ID, "Waldorf Salad", 2000);
    public static final Dish fifthDish = new Dish(FIRTH_DISH_ID, "French Fries", 10);
    public static final Dish sixthDish = new Dish(SIXTH_DISH_ID, "Caesar Salad", 120);

    public static final List<Dish> dishes = List.of(firstDish, secondDish, thirdDish, fourthDish, fifthDish, sixthDish);

    public static Dish getUpdated() {
        return new Dish(FIRST_DISH_ID, "Updated Dish", 300);
    }

    public static Dish getNew() {
        return new Dish("New Dish", 999);
    }

}

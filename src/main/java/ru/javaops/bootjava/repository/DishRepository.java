package ru.javaops.bootjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.Dish;

import java.util.List;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {
    @Query("SELECT d FROM Dish d WHERE d.menu.id=:menu_id")
    List<Dish> findDishByMenuId(@Param("menu_id") Integer id);

    @Query("SELECT d FROM Dish d WHERE d.menu.restaurant.id=:restaurant_id")
    List<Dish> findDishByRestaurantId(@Param("restaurant_id") Integer id);
}

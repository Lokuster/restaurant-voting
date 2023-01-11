package ru.javaops.bootjava.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.bootjava.model.Dish;

@Transactional(readOnly = true)
@Tag(name = "Dish Controller")
public interface DishRepository extends BaseRepository<Dish> {
}

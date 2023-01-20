package ru.javaops.bootjava.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class RestaurantTo extends NamedTo {
    Integer voteCount;
    List<MenuTo> menus;

    public RestaurantTo(Integer id, String name, Integer voteCount, List<MenuTo> menus) {
        super(id, name);
        this.voteCount = voteCount;
        this.menus = menus;
    }
}

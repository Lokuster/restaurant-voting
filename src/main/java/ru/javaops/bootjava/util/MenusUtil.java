package ru.javaops.bootjava.util;

import lombok.experimental.UtilityClass;
import ru.javaops.bootjava.model.Dish;
import ru.javaops.bootjava.model.Menu;
import ru.javaops.bootjava.to.MenuTo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class MenusUtil {

    public static MenuTo asTo(Menu menu, List<Dish> dishList) {
        return new MenuTo(menu.getMenuDate(), DishesUtil.listAsTo(dishList));
    }

    public static List<MenuTo> listAsTo(List<Dish> dishList) {
        Map<Menu, List<Dish>> menuMap = dishList.stream().collect(Collectors.groupingBy(Dish::getMenu));
        return menuMap.entrySet().stream()
                .map(entry -> asTo(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}

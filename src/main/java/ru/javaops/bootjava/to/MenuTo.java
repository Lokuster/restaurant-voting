package ru.javaops.bootjava.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class MenuTo extends BaseTo {
    Date menuDate;
    List<DishTo> dishes;
}

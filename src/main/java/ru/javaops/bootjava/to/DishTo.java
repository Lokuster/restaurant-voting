package ru.javaops.bootjava.to;

public class DishTo extends NamedTo {
    private Integer price;

    public DishTo(Integer id, String name, Integer price) {
        super(id, name);
        this.price = price;
    }
}

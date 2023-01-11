package ru.javaops.bootjava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dish extends NamedEntity implements Serializable {
    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    public Dish(int id, String name, int price) {
        super(id, name);
        this.price = price;
    }

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Dish(Dish dish) {
        super(dish.id, dish.name);
        this.price = dish.price;
    }
}

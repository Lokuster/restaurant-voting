package ru.javaops.bootjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Menu menu;

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
        this.menu = dish.menu;
    }
}

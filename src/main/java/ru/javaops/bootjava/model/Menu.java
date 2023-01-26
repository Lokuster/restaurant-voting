package ru.javaops.bootjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.Date;

@Table(name = "menus")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {
    @Column(name = "menu_date", nullable = false)
    @NotNull
    private Date menuDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    @BatchSize(size = 200)
    private Restaurant restaurant;
}

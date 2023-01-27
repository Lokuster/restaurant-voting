package ru.javaops.bootjava.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "votes")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Vote extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "vote_date", nullable = false, columnDefinition = "timestamp default now()")
    private Date voteDate;
}

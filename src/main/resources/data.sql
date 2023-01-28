INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@javaops.ru', '{noop}admin');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANTS (NAME)
VALUES ('First Restaurant'),
       ('Second Restaurant'),
       ('Third Restaurant');

INSERT INTO DISHES (NAME, PRICE, RESTAURANT_ID)
VALUES ('First Dish', 100, 1),
       ('Second Dish', 150, 1),
       ('Third Dish', 200, 1),
       ('Fourth Dish', 100, 2),
       ('Firth Dish', 150, 2),
       ('Sixth Dish', 200, 2),
       ('Seventh Dish', 100, 3),
       ('Eighth Dish', 150, 3),
       ('Ninth Dish', 200, 3);

INSERT INTO VOTES (RESTAURANT_ID, USER_ID)
VALUES (1, 1);
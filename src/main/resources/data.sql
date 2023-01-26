INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@javaops.ru', '{noop}admin');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANTS (NAME, VOTE_COUNT)
VALUES ('First Restaurant', 0),
       ('Second Restaurant', 0),
       ('Third Restaurant', 0);

INSERT INTO MENUS (MENU_DATE, RESTAURANT_ID)
VALUES (NOW(), 1),
       (NOW(), null),
       (NOW(), null),
       (NOW(), null),
       (NOW(), null);

 INSERT INTO DISHES (NAME, PRICE, MENU_ID)
 VALUES ('Beef Stroganoff', 100, 1),
        ('Reuben', 250, 1),
        ('Sandwich', 200, 2),
        ('Waldorf Salad', 2000, 2),
        ('French Fries', 10, 3),
        ('Caesar Salad', 120, 3);
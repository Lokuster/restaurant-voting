INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@javaops.ru', '{noop}admin');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (NAME, VOTE_COUNT)
VALUES ('Cloth Mone', null);

INSERT INTO MENU (MENU_DATE, RESTAURANT_ID)
VALUES ('2023-01-10', 1),
       ('2023-01-11', null),
       ('2023-01-12', null),
       ('2023-01-13', null),
       ('2023-01-14', null);

 INSERT INTO DISH (NAME, PRICE, MENU_ID)
 VALUES ('Beef Stroganoff', 100, 1),
        ('Reuben', 250, 1),
        ('Sandwich', 200, 2),
        ('Waldorf Salad', 2000, 2),
        ('French Fries', 10, 3),
        ('Caesar Salad', 120, 3);
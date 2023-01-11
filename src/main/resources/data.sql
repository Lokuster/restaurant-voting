INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@javaops.ru', '{noop}admin');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

 INSERT INTO DISH (NAME, PRICE)
 VALUES ('Beef Stroganoff', 100),
        ('Reuben', 250),
        ('Sandwich', 200),
        ('Waldorf Salad', 2000),
        ('French Fries', 10),
        ('Caesar Salad', 120);

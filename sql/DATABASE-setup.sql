create database cars;
use cars;

create table car
(
    id           int            not null,
    age_of_issue int            not null,
    color        varchar(255)   not null,
    mileage      bigint         not null,
    model        varchar(255)   not null,
    number       varchar(255)   not null,
    price        decimal(38, 2) not null,
    garage_id    int            null
)
    engine = MyISAM;

create index car_garage_id_fk
    on car (garage_id);

create table garage
(
    id       int          not null,
    title    varchar(256) not null,
    capacity int          null
);

create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

insert into hibernate_sequence (next_val)
values (10);

create table user
(
    id       int          not null,
    login    varchar(50)  not null,
    mail     varchar(100) null,
    password varchar(100) not null,
    age      int          null,
    role     varchar(10)  not null,
    constraint user_login_uindex
        unique (login),
    constraint user_mail_uindex
        unique (mail)
);

insert into garage (id, title, capacity)
    value (1,'Main garage',12);

insert into car (id, age_of_issue, color, mileage, model, number, price, garage_id)
values (1,2,'White',5000,'Tesla Model X',112233,30000.00,1),
    (2,10,'Red',12000,'Toyota Camry',131323,6000.00,1),
    (3,6,'Grey',8000,'Chevrolet Cruze',333333,12000.00,null),
    (4,3,'Black',3900,'BMW 3 Series Sedan 330i',111111,18000.00,null);

insert into cars.user (id, login, mail, password, age, role)
values (1,'admin',null,'$2a$10$ctOjU5BOj3fxTOPMsslY.uN2oJ7Z2E1C91MoWCGcxjTbfrFSMYlim',25,'ROLE_ADMIN'),
    (2,'user','user.mail@mail.com','$2a$10$r8l4RRte2sfM30i9L/2mtOpIUl.c/qIhQN7/PYCJwGVclychVOB2u',28,'ROLE_USER');

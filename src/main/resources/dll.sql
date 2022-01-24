create database cafe;

use cafe;

create table if not exists admin(
	login varchar(100) unique not null,
    password varchar(18) not null
);

create table if not exists categories(
	id INT auto_increment primary key,
    category varchar(50) unique not null
);

create table if not exists products(
	id INT auto_increment primary key,
    dishName varchar(100) not null,
    price varchar(12) not null,
    description varchar(2000) not null,
    category varchar(50) not null,
    picture varchar(100) not null,
    foreign key(category) references categories(category)
);

create table if not exists statuses(
	id INT auto_increment primary key,
    status varchar(15) unique not null
);

create table if not exists orders(
	id INT auto_increment primary key,
    dishes varchar(2000) not null,
    price varchar(12) not null,
    phoneNumber varchar(20) not null,
    consumerName varchar(100) not null,
    time varchar(15) not null,
    status varchar(15) not null,
    foreign key(status) references statuses(status)
);
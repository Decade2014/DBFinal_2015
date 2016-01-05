/*drop database if exists weather;
create database weather character set utf8;
use weather;
CREATE TABLE ww (
    city VARCHAR(20) PRIMARY KEY,
    weather VARCHAR(20),
    lowest VARCHAR(10),
    conn VARCHAR(5),
    highest VARCHAR(10)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;*/

-- drop database if exists finalproj
-- create database finalproj
use finalproj;
CREATE TABLE user (
    name VARCHAR(20) PRIMARY KEY,
    passwd VARCHAR(20)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tomorrow (
    city VARCHAR(20) PRIMARY KEY,
    weather VARCHAR(20),
	high VARCHAR(20),
    low VARCHAR(20),
    fx VARCHAR(20),
    info varchar(20)
   
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE yesterday (
    city VARCHAR(20) PRIMARY KEY,
    weather VARCHAR(20),
	high VARCHAR(20),
    low VARCHAR(20),
    fx VARCHAR(20),
    info varchar(20)
   
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE today (
    city VARCHAR(20) PRIMARY KEY,
    weather VARCHAR(20),
	high VARCHAR(20),
    low VARCHAR(20),
    fx VARCHAR(20),
    info varchar(20)
   
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

create table userInfo(
name varchar(10) primary key,
province varchar(10),
city varchar(10),
weatherPrefer varchar(10),
cityCare varchar(20),
foreign key(name) references user(name),
foreign key(city) references Today(city),
foreign key(city) references Tomorrow(city),
foreign key(city) references Yesterday(city)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

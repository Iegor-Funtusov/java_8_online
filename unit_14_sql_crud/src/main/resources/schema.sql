create schema 'java_8' default character set utf8;

use 'java_8';

create table students
(
    id bigint auto_increment primary key,
    first_name varchar(255),
    last_name varchar(255),
    age int
);

drop table posts if exists;

create table posts
(
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    content clob not null,
    title varchar(500) not null,
    primary key (id)
);

drop table if exists user;

create table user
(
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    email varchar(255) not null,
    name varchar(255) not null,
    picture varchar(255),
    role varchar(255) not null,
    primary key (id)
);
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

drop table program if exists;
create table program
(
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    author_id bigint not null,
    content clob not null,
    title varchar(500) not null,
    primary key (id)
);

CREATE INDEX author_id ON program(author_id);

drop table qna if exists;
create table qna
(
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    author_id bigint not null,
    content clob not null,
    title varchar(500) not null,
    primary key (id)
);

CREATE INDEX title ON qna(title);

drop table apointment if exists;
create table apointment
(
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    program_id bigint not null,
    apointment_date date,
    phone_number varchar(500),
    uniqueness clob not null,
    user_id bigint not null,
    primary key (id),
    FOREIGN KEY (program_id)
    REFERENCES PROGRAM(ID),
    FOREIGN KEY (user_id)
    REFERENCES USER(ID)
);


DROP DATABASE IF EXISTS social_network;
CREATE DATABASE social_network;
USE social_network;

create table users
(
    id binary(16) not null primary key,
    created_at datetime null,
    name varchar(255) null,
    constraint UK_3g1j96g94xpk3lpxl2qbl985x
        unique (name)
);

create table messages
(
    id binary(16) not null primary key,
    created_at datetime null,
    message    varchar(255) null,
    owner_id   binary(16) not null,
    constraint FKf5nm3ov34hjo0njg2k6rl4p7d
        foreign key (owner_id) references users (id)
);

create table following_rel
(
    user_id   binary(16) not null,
    parent_id binary(16) not null,
    primary key (user_id, parent_id),
    constraint FKitiihvg01w82nuefgs740h0py
        foreign key (parent_id) references users (id),
    constraint FKon0tuybwxhca6es2ouuxjujtg
        foreign key (user_id) references users (id)
);

-- sample data

INSERT INTO social_network.users (id, created_at, name)
VALUES (0x53055705719B4111BCAAD99AF6DED634, '2022-03-30 18:23:32', 'Charlie');
INSERT INTO social_network.users (id, created_at, name)
VALUES (0xECC1ACCE879544C2972DB656EB19719F, '2022-03-30 17:43:43', 'Alice');

INSERT INTO social_network.messages (id, created_at, message, owner_id)
VALUES (0x40268F48DDD34F8695A0DF3CAB430213, '2022-03-30 18:23:32', 'New World!!!', 0x53055705719B4111BCAAD99AF6DED634);
INSERT INTO social_network.messages (id, created_at, message, owner_id)
VALUES (0x4CA45BE1CE1F4C62926B6E57AFCDB234, '2022-03-30 17:43:43', 'Hello World!!!',
        0xECC1ACCE879544C2972DB656EB19719F);
INSERT INTO social_network.messages (id, created_at, message, owner_id)
VALUES (0x7542C0D4FCED488AA4E2F1762319E9EB, '2022-03-30 17:43:53', 'New Message!!!',
        0xECC1ACCE879544C2972DB656EB19719F);

INSERT INTO social_network.following_rel (user_id, parent_id)
VALUES (0xECC1ACCE879544C2972DB656EB19719F, 0x53055705719B4111BCAAD99AF6DED634);


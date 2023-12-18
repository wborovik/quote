create sequence if not exists global_sequence increment 1;

create table if not exists user_account
(
    id bigint not null primary key,
    created timestamp(6) not null,
    changed timestamp(6),
    name varchar not null,
    email varchar unique not null,
    password varchar not null
);

create table if not exists vote
(
    id bigint not null primary key,
    created timestamp(6) not null,
    changed timestamp(6),
    vote integer
);

create index order_vote on vote using btree (vote);

create table if not exists quote
(
    id bigint not null primary key,
    created timestamp(6) not null,
    changed timestamp(6),
    quote varchar not null,
    user_id bigint,
    vote_id bigint
);

alter table if exists quote add constraint user_quote_fk foreign key (user_id) references user_account;
alter table if exists quote add constraint vote_quote_fk foreign key (vote_id) references vote;

-- create table vote_aud
-- (
--     id bigint,
--     rev integer,
--     revtype tinyint,
--     changed timestamp(6),
--     vote integer
-- );
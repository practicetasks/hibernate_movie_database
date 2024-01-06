create table genres
(
    id   serial primary key,
    name varchar not null
);


create table movies
(
    id     serial primary key,
    name   varchar,
    year   integer,
    rating numeric(4, 2),
    count  integer
);


create table movies_genres
(
    id       serial primary key,
    movie_id integer references movies (id),
    genre_id integer references genres (id)
);


create table actors
(
    id   serial primary key,
    name varchar
);

create table actors_movies
(
    id       serial primary key,
    movie_id integer references movies (id),
    actor_id integer references actors (id)
);

create table directors
(
    id   serial primary key,
    name varchar
);

create table directors_movies
(
    id          serial primary key,
    movie_id    integer references movies (id),
    director_id integer references directors (id)
);


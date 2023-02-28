CREATE TABLE IF NOT EXISTS player (
    id int not null AUTO_INCREMENT primary key,
    name varchar(20),
    mark Varchar(1)
);

CREATE TABLE IF NOT EXISTS game (
    id int not null AUTO_INCREMENT primary key,
    height int not null default 3,
    width int not null default 3,
    line_lenght int not null default 3,
    nb_player int not null default 2
);

CREATE TABLE IF NOT EXISTS play (
    id int not null AUTO_INCREMENT primary key,
    player_id int,
    game_id int,
    random_order float default rand(),
    foreign key (player_id) references player(id),
    foreign key (game_id) references game(id)
);

CREATE TABLE IF NOT EXISTS move (
    id int not null AUTO_INCREMENT primary key,
    play_id int,
    x int,
    y int,
    move_time timestamp default now(),
    foreign key (play_id) references play(id)
);
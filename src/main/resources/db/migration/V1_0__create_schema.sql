CREATE TABLE IF NOT EXISTS player (
    id int not null AUTO_INCREMENT primary key,
    name varchar(20),
    mark char(1)
);

CREATE TABLE IF NOT EXISTS game (
    id int not null AUTO_INCREMENT primary key,
    height int not null,
    width int not null,
    rng_seed int
);

CREATE TABLE IF NOT EXISTS play (
    id int not null AUTO_INCREMENT primary key,
    player_id int,
    game_id int,
    foreign key (player_id) references player(id),
    foreign key (game_id) references game(id)
);

CREATE TABLE IF NOT EXISTS move (
    id int not null AUTO_INCREMENT primary key,
    play_id int,
    w int,
    h int,
    round int,
    foreign key (play_id) references play(id)
);
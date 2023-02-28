insert into player VALUES (1, 'alice', 'O');
insert into player VALUES (2, 'bob', 'X');
insert into player VALUES (3, 'jack', 'N');

insert into game(id) VALUES (1);
insert into game(id) VALUES (2);
insert into game(id) VALUES (3);

insert into play(id, player_id, game_id) VALUES (1, 1, 1);
insert into play(id, player_id, game_id) VALUES (2, 2, 1);

insert into play(id, player_id, game_id) VALUES (3, 2, 2);
insert into play(id, player_id, game_id) VALUES (4, 3, 2);

insert into play(id, player_id, game_id) VALUES (5, 1, 3);



insert into move(play_id, x, y, move_time) VALUES (1, 0, 0, '2012-09-17 18:47:00');
insert into move(play_id, x, y, move_time) VALUES (2, 0, 1, '2012-09-17 18:48:00');


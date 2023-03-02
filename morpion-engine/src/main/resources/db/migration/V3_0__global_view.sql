CREATE VIEW IF NOT EXISTS player_move AS
Select j.name as name, j.id as player_id, j.mark as mark,  p.game_id as game_id, m.x as x, m.y as y from move m
inner join play p on m.play_id=p.id
inner join player j on p.player_id=j.id
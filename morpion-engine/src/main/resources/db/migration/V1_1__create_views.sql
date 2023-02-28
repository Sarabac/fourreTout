CREATE VIEW IF NOT EXISTS round_order AS
Select p.game_id as game_id, p.player_id as player_id, max(p.random_order) as player_order, max(m.move_time) as last_move_time
from play p
left join move m on m.play_id=p.id
group by game_id, player_id
order by game_id, last_move_time, player_order;
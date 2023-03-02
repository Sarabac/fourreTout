package com.ultramorpion.engine.mapper;

import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import com.ultramorpion.model.GameMove;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameMapper {
    Integer countRemaningMoves(Integer gameId);

    List<GameMove> getGameMoves(Integer gameId);

    Optional<Game> findGame(Integer gameId);

    Optional<Game> findGameByPlayId(Integer playId);

    @Select("select mark, x, y from player_move where game_id=(select game_id from play where id=#{playId})")
    List<GameCell> getMoveByPlayId(Integer playId);

    @Select("SELECT g.nb_player-COUNT(p.id) FROM game g LEFT JOIN play p ON p.game_id=g.id WHERE g.id=#{gameId} GROUP BY g.id")
    Integer countRemaningPlayer(Integer gameId);

    @Insert("Insert into move(play_id, x, y) Values(#{playId}, #{x}, #{y})")
    void insertMove(Integer playId, Integer x, Integer y);

    @Select("SELECT p.id FROM play p " +
            "WHERE p.player_id=(SELECT player_id FROM round_order WHERE game_id=#{gameId} LIMIT 1) " +
            "AND p.game_id=#{gameId} LIMIT 1")
    Optional<Integer> nextPlayId(Integer gameId);

}

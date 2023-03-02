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

    @Insert("Insert into move(play_id, x, y) Values(#{playId}, #{x}, #{y})")
    void insertMove(Integer playId, Integer x, Integer y);

}

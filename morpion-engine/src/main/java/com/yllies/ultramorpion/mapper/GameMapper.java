package com.yllies.ultramorpion.mapper;

import com.yllies.ultramorpion.model.Game;
import com.yllies.ultramorpion.model.GameMove;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameMapper {
    Integer countRemaningMoves(Integer gameId);

    List<GameMove> getGameMoves(Integer gameId);

    Optional<Game> findGame(Integer gameId);
}

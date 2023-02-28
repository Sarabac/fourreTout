package com.yllies.morpion.mapper;

import com.yllies.morpion.model.Game;
import com.yllies.morpion.model.GameMove;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameMapper {
    Integer countRemaningMoves(Integer gameId);

    List<GameMove> getGameMoves(Integer gameId);

    Optional<Game> findGame(Integer gameId);
}

package com.yllies.morpion.mapper;

import com.yllies.morpion.model.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PlayerMapper {
    List<Player> findAllPlayer();

    Optional<Player> findPlayer(Integer playerId);
}

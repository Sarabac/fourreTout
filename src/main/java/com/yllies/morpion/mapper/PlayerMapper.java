package com.yllies.morpion.mapper;

import com.yllies.morpion.model.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMapper {
    List<Player> findAllPlayer();
}

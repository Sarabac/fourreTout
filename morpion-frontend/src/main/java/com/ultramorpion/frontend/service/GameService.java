package com.ultramorpion.frontend.service;

import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import com.ultramorpion.model.GameMove;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    public Game getGameSettings(Integer playId){
        return new Game(1, 3, 3, 3, 2);
    }

    public List<GameCell> getGameCells(Integer playId){
        List<GameCell> result = new ArrayList<>();
        result.add(new GameCell("X", 0, 0));
        result.add(new GameCell("O", 0, 1));
        result.add(new GameCell("X", 1, 1));
        return result;
    }

    public boolean makeMove(Integer playId, Integer x, Integer y){
        return true;
    }
}

package com.ultramorpion.frontend.controller;

import com.ultramorpion.frontend.service.GameService;
import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController("/game")
public class GameController {

    GameService gameService;

    GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("play/{play_id}")
    public ModelAndView play(@PathVariable Integer play_id){
        ModelAndView modelAndView = new ModelAndView("game_board");
        Game game = gameService.getGameSettings(play_id);
        List<GameCell> gameCells = gameService.getGameCells(play_id);
        modelAndView.addObject("cells", game.generateBoard(gameCells));
        modelAndView.addObject("width", game.getWidth());
        modelAndView.addObject("height", game.getHeight());
        modelAndView.addObject("play_id", play_id);
        return modelAndView;
    }
}

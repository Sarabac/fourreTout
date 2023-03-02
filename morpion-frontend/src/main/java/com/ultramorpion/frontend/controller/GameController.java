package com.ultramorpion.frontend.controller;

import com.ultramorpion.frontend.service.GameService;
import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController()
public class GameController {

    GameService gameService;

    GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/game/play/{play_id}")
    public ModelAndView play(@PathVariable Integer play_id){
        return gameService
                .getGameSettings(play_id)
                .map(game -> game.generateBoard(gameService.getGameCells(play_id)))
                .map(gameCells -> {
                    ModelAndView modelAndView = new ModelAndView("game_board");
                    modelAndView.addObject("cells", gameCells);
                    modelAndView.addObject("play_id", play_id);
                    return modelAndView;
                }).orElseGet(() -> new ModelAndView("game_doesnt_exist"));
    }

    @GetMapping("/game/move/{play_id}/{x}/{y}")
    public RedirectView move(@PathVariable Integer play_id, @PathVariable Integer x, @PathVariable Integer y){
        boolean succed = gameService.makeMove(play_id, x, y);
        return new RedirectView(String.format("/game/play/%s", play_id));

    }
}

package com.ultramorpion.engine;

import com.ultramorpion.engine.mapper.GameMapper;
import com.ultramorpion.engine.mapper.PlayerMapper;
import com.ultramorpion.engine.mapper.PlayerMapper;
import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import com.ultramorpion.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MorpionController {

    MorpionService morpionService;

    Logger logger = LoggerFactory.getLogger(MorpionController.class);

    PlayerMapper playerMapper;

    GameMapper gameMapper;
    Session session = new Session(1, null);

    public MorpionController(MorpionService morpionService, PlayerMapper playerMapper, GameMapper gameMapper) {
        this.playerMapper = playerMapper;
        this.morpionService = morpionService;
        this.gameMapper = gameMapper;
    }

    @GetMapping("/game/settings/{play_id}")
    public ResponseEntity<Game> getGameByPlayId(@PathVariable Integer play_id) {
        return gameMapper.findGameByPlayId(play_id).map(
                game -> new ResponseEntity<>(game, HttpStatus.OK)
        ).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/game/cells/{play_id}")
    public ResponseEntity<List<GameCell>> getMoveByPlayId(@PathVariable Integer play_id){
        return new ResponseEntity<>(gameMapper.getMoveByPlayId(play_id), HttpStatus.OK);
    }

    @GetMapping("/game/make_move/{play_id}/{x}/{y}")
    public ResponseEntity<Boolean> makeMove(@PathVariable Integer play_id, @PathVariable Integer x, @PathVariable Integer y) {
        Boolean result = morpionService.makeMove(play_id, x, y);
        HttpStatus status = result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayer() {
        return new ResponseEntity<List<Player>>(playerMapper.findAllPlayer(), HttpStatus.OK);
    }
}

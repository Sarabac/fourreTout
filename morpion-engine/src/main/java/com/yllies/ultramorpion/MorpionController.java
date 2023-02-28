package com.yllies.ultramorpion;

import com.yllies.ultramorpion.mapper.PlayerMapper;
import com.yllies.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MorpionController {

    MorpionService morpionService;

    PlayerMapper playerMapper;
    Session session = new Session(1, null);

    public MorpionController(MorpionService morpionService, PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
        this.morpionService = morpionService;
    }

    @GetMapping("/play/{id}/{x}/{y}")
    public ResponseEntity<String> play(@PathVariable Integer id, @PathVariable Integer x, @PathVariable Integer y) {
        return new ResponseEntity<>(morpionService.play(session, id, x, y), HttpStatus.OK);
    }


    @GetMapping("/showGrid")
    public ResponseEntity<String> showGrid() {
        return new ResponseEntity<>(morpionService.showGrid(session), HttpStatus.OK);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayer() {
        return new ResponseEntity<List<Player>>(playerMapper.findAllPlayer(), HttpStatus.OK);
    }
}

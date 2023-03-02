package com.ultramorpion.frontend.service;

import com.ultramorpion.model.Game;
import com.ultramorpion.model.GameCell;
import com.ultramorpion.model.GameMove;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Value("${morpion-server}")
    private String morpionServer;
    public Optional<Game> getGameSettings(Integer playId){
        RestTemplate restTemplate = new RestTemplate();
        String request = String.format("%s/%s/%s/%s", morpionServer, "game", "settings", playId );
        try{
            ResponseEntity<Game> responseEntity = restTemplate.getForEntity(request, Game.class);
            return Optional.ofNullable(responseEntity.getBody());
        }catch (RestClientException exception){
            return Optional.empty();
        }
    }

    public List<GameCell> getGameCells(Integer playId){
        RestTemplate restTemplate = new RestTemplate();
        String request = String.format("%s/%s/%s/%s", morpionServer, "game", "cells", playId);
        try{
            ResponseEntity<GameCell[]> response = restTemplate.getForEntity(request, GameCell[].class);
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        }catch (RestClientException e){
            return new ArrayList<>();
        }
    }

    public boolean makeMove(Integer playId, Integer x, Integer y){
        RestTemplate restTemplate = new RestTemplate();
        String request = String.format("%s/%s/%s/%s/%s/%s", morpionServer, "game", "make_move", playId, x, y);
        try{
            ResponseEntity<Boolean> response = restTemplate.getForEntity(request, Boolean.class);
            return Boolean.TRUE.equals(response.getBody());
        }catch (RestClientException e){
            return false;
        }
    }
}

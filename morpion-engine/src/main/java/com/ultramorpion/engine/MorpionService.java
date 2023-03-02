package com.ultramorpion.engine;

import com.ultramorpion.engine.mapper.GameMapper;
import com.ultramorpion.engine.mapper.PlayerMapper;
import com.ultramorpion.engine.mapper.GameMapper;
import com.ultramorpion.engine.mapper.PlayerMapper;
import com.ultramorpion.model.GameCell;
import com.ultramorpion.model.GameMove;
import com.ultramorpion.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
class Direction {
    private Integer dx;
    private Integer dy;

    public static List<Direction> getMainDirections() {
        return Arrays.asList(new Direction(0, 1), new Direction(1, 0), new Direction(1, 1), new Direction(-1, 1));
    }
}

@Service
public class MorpionService {

    GameMapper gameMapper;
    PlayerMapper playerMapper;

    MorpionService(GameMapper gameMapper, PlayerMapper playerMapper) {
        this.gameMapper = gameMapper;
        this.playerMapper = playerMapper;
    }

    public Boolean makeMove(Integer playId, Integer x, Integer y){
        try{
            gameMapper.insertMove(playId, x, y);
        }catch (PersistenceException pe){
            return false;
        }
        return true;

    }

    public boolean isGameFinished(Integer gameId) {
        return gameMapper.countRemaningMoves(gameId).equals(0);
    }

    public Optional<Player> getWinner(Integer gameId) {
        return gameMapper.findGame(gameId).flatMap(game -> getWinnerId(game.getLine_lenght(), gameMapper.getGameMoves(game.getId())))
                .flatMap(playerMapper::findPlayer);

    }


    public Optional<Integer> getWinnerId(Integer lineLength, List<GameMove> gameMoves) {
        return gameMoves
                .stream()
                .filter(gameMove -> {
                    boolean win = false;
                    for (Direction dir : Direction.getMainDirections()) {
                        boolean winDirection = true;
                        // i=1 n'est pas une erreur
                        for (int i = 1; i < lineLength; i++) {
                            GameMove hypotheticalMove = new GameMove(
                                    gameMove.getPlayer_id(),
                                    gameMove.getX() + i * dir.getDx(),
                                    gameMove.getY() + i * dir.getDy()
                            );
                            winDirection = winDirection & gameMoves.contains(hypotheticalMove);
                        }
                        win = win | winDirection;
                    }
                    return win;
                })
                .map(GameMove::getPlayer_id)
                .findFirst();
    }

    public String play(Session s, Integer id, Integer x, Integer y) {
        if (id == null) {
            return "Il manque l'identifiant du joueur";
        }
        if (x == null || y == null) {
            return "Il manque la position";
        }

        if (x < 1 || y < 1 || x > 3 || y > 3) {
            return String.format("La position (%d, %d) n'existe pas dans le plateau<br><br>", x, y);
        }


        if (s.getBoard() == null) {
            if (id == 2) {
                return "C'est au joueur 1 de commencer la partie";
            }

            s.init();
        }

        if (id != 1 && id != 2) {
            return "Veuillez entrer un identifiant de joueur valide : 1 ou 2" + s;
        }


        if (!id.equals(s.getExpectedUser())) {
            return "Ce n'est pas à votre tour de jouer<br><br>" + s;
        }


        if (!"...".equals(s.getBoard()[x - 1][y - 1])) {
            return String.format("La position (%d, %d) a déjà été utilisée<br><br>", x, y) + s;
        }

        if (id == 1) {
            s.getBoard()[x - 1][y - 1] = "X";
            s.setExpectedUser(2);
            return String.format("Vous avez placé un X à (%d, %d) <br><br>", x, y) + s;
        } else {
            s.getBoard()[x - 1][y - 1] = "O";
            s.setExpectedUser(1);
            return String.format("Vous avez placé un O à (%d, %d) <br><br>", x, y) + s;
        }
    }


    public String showGrid(Session s) {
        return s.toString();
    }

}



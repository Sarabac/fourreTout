package com.ultramorpion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Integer id;
    private Integer height;
    private Integer width;
    private Integer line_lenght;
    private Integer nb_player;

    public List<GameCell> generateBoard(List<GameCell> moves) {
        List<GameCell> result = new ArrayList<>();
        for (Integer x : IntStream.range(0, this.width).boxed().collect(Collectors.toList())) {
            for (Integer y : IntStream.range(0, this.width).boxed().collect(Collectors.toList())) {
                GameCell gameCell = moves
                        .stream()
                        .filter(move -> move.getX().equals(x) && move.getY().equals(y))
                        .findFirst()
                        .orElseGet(() -> new GameCell("", x, y));
                result.add(gameCell);
            }
        }
        return result;
    }
}

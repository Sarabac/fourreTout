package com.ultramorpion.model;

import lombok.Data;

@Data
public class Game {
    private Integer id;
    private Integer height;
    private Integer width;
    private Integer line_lenght;
    private Integer nb_player;
}

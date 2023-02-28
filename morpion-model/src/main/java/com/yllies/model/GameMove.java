package com.yllies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMove {
    private Integer player_id;
    private Integer x;
    private Integer y;
}

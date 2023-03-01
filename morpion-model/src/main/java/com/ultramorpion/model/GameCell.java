package com.ultramorpion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameCell {
    private String mark;
    private Integer x;
    private Integer y;

}

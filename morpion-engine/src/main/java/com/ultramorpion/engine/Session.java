package com.ultramorpion.engine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Session {
    private Integer expectedUser;
    private String[][] board;

    public void init() {
        board = new String[3][3];
        for (int i=0; i<3;++i){
            for (int j=0;j<3;++j){
                board[i][j]="...";
            }
        }
    }

    public String toString() {
        return String.format(" %s | %s | %s <br>", board[0][0], board[1][0], board[2][0])
                + "-----------<br>"
                +String.format(" %s | %s | %s <br>", board[0][1], board[1][1], board[2][1])
                + "-----------<br>"
                +String.format(" %s | %s | %s <br>", board[0][2], board[1][2], board[2][2]);
    }

}

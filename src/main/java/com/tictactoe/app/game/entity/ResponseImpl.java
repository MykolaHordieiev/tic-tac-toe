package com.tictactoe.app.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseImpl {
    private Long gameId;
    private String gameState;
    private Board board;
}

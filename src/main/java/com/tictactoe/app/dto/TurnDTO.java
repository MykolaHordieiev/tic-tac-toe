package com.tictactoe.app.dto;

import com.tictactoe.app.game.entity.Turn;
import lombok.Data;

@Data
public class TurnDTO {
    private Long gameId;
    private Turn turn;
}

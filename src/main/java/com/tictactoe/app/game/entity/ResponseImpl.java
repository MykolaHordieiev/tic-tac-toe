package com.tictactoe.app.game.entity;

import com.tictactoe.app.game.state.State;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResponseImpl {
    private Long gameId;
    private State state;
    private Board board;
}

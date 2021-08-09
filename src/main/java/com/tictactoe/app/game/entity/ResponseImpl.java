package com.tictactoe.app.game.entity;

import com.tictactoe.app.game.state.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseImpl {
    private Long gameId;
    private State state;
    private Board board;
}

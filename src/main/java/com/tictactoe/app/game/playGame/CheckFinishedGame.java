package com.tictactoe.app.game.playGame;

import com.tictactoe.app.game.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckFinishedGame {
    private final CheckWinner checkWinner;
    private final CheckDraw checkDraw;

    public void checkGameIsPlaying(Game game) {
        if (game.getIsPlaying()) {
            return;
        }
        throw new RuntimeException("Game is over");
    }

    public boolean check(Game game) {
        return checkWinner.check(game).isPresent() || checkDraw.check(game).isPresent();
    }
}

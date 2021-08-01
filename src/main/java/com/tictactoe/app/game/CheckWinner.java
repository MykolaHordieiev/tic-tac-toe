package com.tictactoe.app.game;

import com.tictactoe.app.game.configGame.ConfigWinningCombinations;
import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.Player;
import com.tictactoe.app.game.entity.WinningCombination;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class CheckWinner {

    private final ConfigWinningCombinations configWinningCombinations;

    public Optional<Map<String, Optional<Player>>> checkWinnerMethod(Game game) {
        boolean haveWinner = checkHaveWinnerCombination(game).keySet().stream()
                .anyMatch(key -> key.equals("have winner"));
        if (haveWinner) {
            return Optional.of(game.getResult());
        }

        boolean isDraw = checkDraw(game);
        if (isDraw) {
            return Optional.of(game.getResult());
        }

        return Optional.empty();
    }

    private Map<String, Optional<Player>> checkHaveWinnerCombination(Game game) {
        configWinningCombinations.getWinningCombinations(game.getBoard()).stream()
                .map(WinningCombination::getCombination)
                .filter(stringCombination -> stringCombination.equals("XXX"))
                .findFirst()
                .ifPresent(str -> game.getResult().put("have winner", Optional.of(game.getPlayer1())));

        configWinningCombinations.getWinningCombinations(game.getBoard()).stream()
                .map(WinningCombination::getCombination)
                .filter(stringCombination -> stringCombination.equals("OOO"))
                .findFirst()
                .ifPresent(str -> game.getResult().put("have winner", Optional.of(game.getPlayer2())));

        return game.getResult();
    }

    private boolean checkDraw(Game game) {
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(game.getBoard().getBoard()).contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                game.getResult().put("draw", Optional.empty());
                return true;
            }
        }
        return false;
    }

    public Player getWinner(Game game) {
        return game.getResult().get("have winner").orElseThrow(RuntimeException::new);
    }

    public String drawOrWin(Game game) {
        return game.getResult().keySet().stream()
                .filter(string -> string.equals("have winner"))
                .findFirst()
                .orElse("draw");
    }
}


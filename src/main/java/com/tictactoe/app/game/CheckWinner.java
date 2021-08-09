package com.tictactoe.app.game;

import com.tictactoe.app.game.configGame.ConfigWinningCombinations;
import com.tictactoe.app.game.entity.*;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CheckWinner {

    private final ConfigWinningCombinations configWinningCombinations;

    public Optional<Map<String, Optional<Player>>> checkWinnerMethod(Game game) {
        boolean haveWinner = checkHaveWinnerCombination(game).keySet().stream()
                .anyMatch(key -> key.equals("have winner"));
        if (haveWinner) {
            return Optional.of(game.getResult());
        }

        if (checkDraw(game)) {
            return Optional.of(game.getResult());
        }
        return Optional.empty();
    }

    private Map<String, Optional<Player>> checkHaveWinnerCombination(Game game) {
        configWinningCombinations.getWinningCombinations(game.getBoard()).stream()
                .map(WinningCombination::getCombination)
                .filter(stringCombination -> stringCombination.equals("XXX") || stringCombination.equals("OOO"))
                .findFirst()
                .ifPresent(str -> {
                    if (str.equals("XXX")) {
                        game.getResult().put("have winner", Optional.of(game.getPlayer1()));
                    } else {
                        game.getResult().put("have winner", Optional.of(game.getPlayer2()));
                    }
                });
        return game.getResult();
    }

    private boolean checkDraw(Game game) {
        List<String> fields = game.getBoard().getFields().stream()
                .map(Field::toString)
                .collect(Collectors.toList());
        for (int a = 0; a < 9; a++) {
            if (fields.contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                game.getResult().put("draw", Optional.empty());
                return true;
            }
        }
        return false;
    }
}


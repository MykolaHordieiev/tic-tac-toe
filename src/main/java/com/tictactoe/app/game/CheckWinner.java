package com.tictactoe.app.game;

import com.tictactoe.app.game.configGame.ConfigWinningCombinations;
import com.tictactoe.app.game.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CheckWinner {
    private final ConfigWinningCombinations configWinningCombinations;
    private final ConfigState configState;

    public Optional<Map<String, Optional<Player>>> check(Game game) {
        boolean haveWinner = checkHaveWinnerCombination(game).containsKey(GameEnums.HAVE_WINNER.name());
        if (haveWinner) {
            game.setState(configState.getStateByDescription(GameEnums.HAVE_WINNER.name()));
            return Optional.of(game.getResult());
        }
        return Optional.empty();
    }

    private Map<String, Optional<Player>> checkHaveWinnerCombination(Game game) {
        configWinningCombinations.getWinningCombinations(game.getBoard().getFields()).stream()
                .filter(stringCombination -> stringCombination.equals(GameEnums.XXX.name())
                        || stringCombination.equals(GameEnums.OOO.name()))
                .findFirst()
                .ifPresent(str -> {
                    if (str.equals(GameEnums.XXX.name())) {
                        game.getResult().put(GameEnums.HAVE_WINNER.name(), Optional.of(game.getPlayer1()));
                    } else {
                        game.getResult().put(GameEnums.HAVE_WINNER.name(), Optional.of(game.getPlayer2()));
                    }
                });
        return game.getResult();
    }
}


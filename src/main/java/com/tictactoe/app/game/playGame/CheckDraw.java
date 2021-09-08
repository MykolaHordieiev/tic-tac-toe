package com.tictactoe.app.game.playGame;

import com.tictactoe.app.game.configGame.ConfigState;
import com.tictactoe.app.game.entity.Field;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.GameEnums;
import com.tictactoe.app.game.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CheckDraw {
    private final ConfigState configState;

    public Optional<Map<String, Optional<Player>>> check(Game game) {
        List<String> fields = game.getBoard().getFields().stream()
                .map(Field::toString)
                .collect(Collectors.toList());
        for (int a = 0; a < 9; a++) {
            if (fields.contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                game.getResult().put(GameEnums.DRAW.name(), Optional.empty());
                game.setState(configState.getStateByDescription(GameEnums.DRAW.name()));
                return Optional.of(game.getResult());
            }
        }
        return Optional.empty();
    }
}

package com.tictactoe.app.game.playGame;

import com.tictactoe.app.dto.TurnDto;
import com.tictactoe.app.game.configGame.ConfigGame;
import com.tictactoe.app.game.configGame.ConfigState;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.playGame.CheckFinishedGame;
import com.tictactoe.app.person.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Play {

    private final CheckFinishedGame checkFinishedGame;
    private final ConfigGame configGame;
    private final ConfigState configState;

    public Game startGame(Person person1, Person person2) {
        return configGame.startNewGame(person1, person2);
    }

    public Game turn(Game game, TurnDto turnDTO) {
        checkFinishedGame.checkGameIsPlaying(game);

        game.getBoard().getFields().stream()
                .filter(field -> field.toString().equals(String.valueOf(turnDTO.getTurn())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Slot already taken; re-enter slot number:"))
                .setValue(game.getState().getRequiredTurn());

        game.setState(configState.getNextState(game.getState()));

        if (checkFinishedGame.check(game)) {
            game.setIsPlaying(false);
            return game;
        }
        return game;
    }
}

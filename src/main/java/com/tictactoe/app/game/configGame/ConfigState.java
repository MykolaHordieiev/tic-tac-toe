package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.service.StateService;
import com.tictactoe.app.game.entity.GameEnums;
import com.tictactoe.app.game.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ConfigState {
    private final StateService stateService;

    public State getStateByDescription(String description) {
        return stateService.getStateByDescription(description);
    }

    public State getNextState(State state) {
        String turn = state.getRequiredTurn();
        if (turn.equals(GameEnums.X.name())) {
            return stateService.getStateByDescription(GameEnums.REQUIRED_TURN_O.name());
        } else {
            return stateService.getStateByDescription(GameEnums.REQUIRED_TURN_X.name());
        }
    }
}

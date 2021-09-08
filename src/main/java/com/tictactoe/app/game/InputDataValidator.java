package com.tictactoe.app.game;

import com.tictactoe.app.dto.TurnDto;
import org.springframework.stereotype.Component;

@Component
public class InputDataValidator {
    public TurnDto validEnteredSlotNumber(TurnDto turnDTO) {
        int numInput = turnDTO.getTurn();
        if (numInput <= 0 || numInput > 9) {
            throw new RuntimeException("Invalid input; re-enter slot number:");
        }
        return turnDTO;
    }
}

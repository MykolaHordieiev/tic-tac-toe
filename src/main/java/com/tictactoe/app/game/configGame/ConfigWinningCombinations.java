package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.service.WinningCombinationService;
import com.tictactoe.app.game.entity.Field;
import com.tictactoe.app.game.entity.WinningCombination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConfigWinningCombinations {
    private final WinningCombinationService winningCombinationService;

    public List<String> getWinningCombinations(List<Field> fields) {
        List<String> orderedFieldList = new ArrayList<>();
        List<WinningCombination> allWinningCombination = winningCombinationService.getAllWinningCombination();
        for (WinningCombination combination : allWinningCombination) {
            String firstField = getFieldValue(fields, combination.getFirstFieldNumber()).toString();
            String secondField = getFieldValue(fields, combination.getSecondFieldNumber()).toString();
            String thirdField = getFieldValue(fields, combination.getThirdFieldNumber()).toString();
            orderedFieldList.add(firstField + secondField + thirdField);
        }
        return orderedFieldList;
    }

    private Field getFieldValue(List<Field> fields, int fieldNumber) {
        return fields.get(fieldNumber);
    }
}

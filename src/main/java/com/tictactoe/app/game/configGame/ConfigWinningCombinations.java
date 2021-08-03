package com.tictactoe.app.game.configGame;

import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.entity.WinningCombination;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfigWinningCombinations {

    public List<WinningCombination> getWinningCombinations(Board board) {
        List<WinningCombination> winningCombinationsList = new ArrayList<>();

        WinningCombination winningCombination1 = createWinningCombination(board.getBoard()[0] + board.getBoard()[1] + board.getBoard()[2]);
        WinningCombination winningCombination2 = createWinningCombination(board.getBoard()[3] + board.getBoard()[4] + board.getBoard()[5]);
        WinningCombination winningCombination3 = createWinningCombination(board.getBoard()[6] + board.getBoard()[7] + board.getBoard()[8]);
        WinningCombination winningCombination4 = createWinningCombination(board.getBoard()[0] + board.getBoard()[3] + board.getBoard()[6]);
        WinningCombination winningCombination5 = createWinningCombination(board.getBoard()[1] + board.getBoard()[4] + board.getBoard()[7]);
        WinningCombination winningCombination6 = createWinningCombination(board.getBoard()[2] + board.getBoard()[5] + board.getBoard()[8]);
        WinningCombination winningCombination7 = createWinningCombination(board.getBoard()[0] + board.getBoard()[4] + board.getBoard()[8]);
        WinningCombination winningCombination8 = createWinningCombination(board.getBoard()[2] + board.getBoard()[4] + board.getBoard()[6]);

        winningCombinationsList.add(winningCombination1);
        winningCombinationsList.add(winningCombination2);
        winningCombinationsList.add(winningCombination3);
        winningCombinationsList.add(winningCombination4);
        winningCombinationsList.add(winningCombination5);
        winningCombinationsList.add(winningCombination6);
        winningCombinationsList.add(winningCombination7);
        winningCombinationsList.add(winningCombination8);

        return winningCombinationsList;
    }

    private WinningCombination createWinningCombination(String combination) {
        return new WinningCombination(combination);
    }
}

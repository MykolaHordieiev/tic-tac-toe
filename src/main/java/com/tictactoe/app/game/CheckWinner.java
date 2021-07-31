package com.tictactoe.app.game;

import com.tictactoe.app.game.entity.Board;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.Player;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class CheckWinner {

    public Optional<Map<String, Optional<Player>>> checkWinnerMethod(Game game) {
        Map<String, Optional<Player>> result = game.getResult();
        Board board = game.getBoard();
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board.getBoard()[0] + board.getBoard()[1] + board.getBoard()[2];
                    break;
                case 1:
                    line = board.getBoard()[3] + board.getBoard()[4] + board.getBoard()[5];
                    break;
                case 2:
                    line = board.getBoard()[6] + board.getBoard()[7] + board.getBoard()[8];
                    break;
                case 3:
                    line = board.getBoard()[0] + board.getBoard()[3] + board.getBoard()[6];
                    break;
                case 4:
                    line = board.getBoard()[1] + board.getBoard()[4] + board.getBoard()[7];
                    break;
                case 5:
                    line = board.getBoard()[2] + board.getBoard()[5] + board.getBoard()[8];
                    break;
                case 6:
                    line = board.getBoard()[0] + board.getBoard()[4] + board.getBoard()[8];
                    break;
                case 7:
                    line = board.getBoard()[2] + board.getBoard()[4] + board.getBoard()[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                result.put("have winner", Optional.of(game.getPlayer1()));
                return Optional.of(result);
            }

            // For O winner
            else if (line.equals("OOO")) {
                result.put("have winner", Optional.of(game.getPlayer2()));
                return Optional.of(result);
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board.getBoard()).contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                result.put("draw", Optional.empty());
                return Optional.of(result);
            }
        }
        return Optional.empty();
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


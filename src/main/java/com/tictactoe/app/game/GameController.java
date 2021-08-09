package com.tictactoe.app.game;

import com.tictactoe.app.dto.StartGameDto;
import com.tictactoe.app.dto.TurnDto;
import com.tictactoe.app.game.entity.Game;
import com.tictactoe.app.game.entity.ResponseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/tic-tac-toe")
    public String welcome() {
        return "Welcome to 3x3 Tic Tac Toe. Please enter person's login who will play";
    }

    @PostMapping("/tic-tac-toe/start")
    public ResponseImpl startGame(@RequestBody StartGameDto startGameDTO) {
        Game game = gameService.startGame(startGameDTO);
        return new ResponseImpl(game.getId(), game.getState().getState(), game.getBoard());
    }

    @PostMapping("/turn")
    public ResponseImpl requiredTurn(@RequestBody TurnDto turnDTO) {
        Game game = gameService.turn(turnDTO);
        return new ResponseImpl(game.getId(), game.getState().getState(), game.getBoard());
    }


}
